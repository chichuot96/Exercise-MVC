package vn.topica.itlab4.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count=0;
//	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.setAttribute("listStudents", StudentDB.getStudents());
//		request.getRequestDispatcher("/Home.jsp").forward(request, response);
//    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(count==0) {
			StudentDB.createDB();
			count++;
		}

		request.setAttribute("listStudents", StudentDB.getListStudents());
		request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
