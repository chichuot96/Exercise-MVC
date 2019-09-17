package vn.topica.itlab4.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 *
 */
@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count=0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(count==0) {
			StudentDB.createDB(); //create database in first time 
			count++;
		}

		request.setAttribute("listStudents", StudentDB.getListStudents());//send data to jsp
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
