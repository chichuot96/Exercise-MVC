package vn.topica.itlab4.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.topica.itlab4.model.Students;

/**
 * Servlet implementation class AddController
 */
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		if ( request.getParameter("name").matches("\\s+") || request.getParameter("birthday").matches("\\s+")
				|| request.getParameter("gender").matches("\\s+") || request.getParameter("date").matches("\\s+")) {
			request.setAttribute("listStudents",  StudentDB.getListStudents());
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		} else {
			String name =request.getParameter("name");
			int yearOfBirth = Integer.parseInt(request.getParameter("birthday"));
			int gender = Integer.parseInt(request.getParameter("gender"));
			String dateStudy = request.getParameter("date");
			boolean g;
			if(gender==0) {
				g=true;
			}else {
				g=false;
			}
			Students s = new Students(name, yearOfBirth, g, dateStudy);
			StudentDB.addStudent(s);
			
			request.setAttribute("message", "Add success");
			response.sendRedirect("/");
		}
	}

}
