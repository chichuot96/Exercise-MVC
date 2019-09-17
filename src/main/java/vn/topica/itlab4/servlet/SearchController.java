package vn.topica.itlab4.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String name=request.getParameter("search");
		//check name to search
		if(name.trim().isEmpty()) {
			request.setAttribute("listStudents", StudentDB.getListStudents());
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}else {
			request.setAttribute("listStudents", StudentDB.searchStudent(name));
			request.setAttribute("textSearch", name);
			request.getRequestDispatcher("Home.jsp").forward(request, response);//get data search and return home page 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	

	}

}
