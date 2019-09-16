package vn.topica.itlab4.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.topica.itlab4.servlet.StudentDB;

/**
 * Servlet implementation class UpdateController
 */
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateController() {
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
		int id = Integer.parseInt(request.getParameter("id2"));
		String name = request.getParameter("name2");
		int yearOfBirth = Integer.parseInt(request.getParameter("year"));
		int gender = Integer.parseInt(request.getParameter("gender2"));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(request.getParameter("date2"));
		Date dateStudy=new Date();
		try {
			dateStudy = df.parse( request.getParameter("date2"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean g;
		if(gender==0) {
			g=true;
		}else {
			g=false;
		}
		StudentDB.updateDB(id, name, yearOfBirth, g, dateStudy);
		request.setAttribute("listStudents",StudentDB.getListStudents());
		request.setAttribute("message", "Update success");
		response.sendRedirect("/");
	}
}
