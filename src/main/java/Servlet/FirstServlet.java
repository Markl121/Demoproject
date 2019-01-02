package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//@WebServlet("/")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//	public FirstServlet() {
//		super();
		// TODO Auto-generated constructor stub
//}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// choices
		// 1)typically handle the get request normal
		
		// 2)will come back to this
		// 3)call parent method, which will throw a generic" method not used"
		//message 
		// throw our own "unavailable" message
//		//throw new ServletException ("Cannot uses this method");
		PrintWriter out = response.getWriter();
		out.append("<html><head><title>First Page</title></head><body><h1>My First Servlet Submit Webpage</h1>");
		// super.doGet(request,response);
		out.append("<p><a href=\"login\">Link to itself</a></p>");
		out.append("<p><from method=\"POST\" action=\"handle\">");
		out.append("input type=\"text\" name=\"someText\" />");
		out.append("input type=\"submit\" value=\"send message\" />");
		out.append("</form></p></body></html>");
		response.sendRedirect("solo.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
