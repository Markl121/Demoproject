package Servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastServlet
 */
@WebServlet("/LastServlet")
public class LastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
    */
//    public LastServlet() {
//        super();
        // TODO Auto-generated constructor stub
  //  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("first");
//		PrintWriter out = response.getWriter();
//		out.append("<html><head><title>First Page</title></head><body><h1>Last point in the workfllowServlet</h1>");
		// super.doGet(request,response);
//		out.append("<p><a href=\"First\">Link to itself</a></p>");
//		out.append("<p><from method=\"POST\" action=\"handle\">");
//		out.append("input type=\"text\" name=\"someText\" />");
//		out.append("input type=\"submit\" value=\"send message\" />");
//		out.append("</form></p></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//set<Book> byName = new UserBookBusinessLogic().set
//		
//		request.setAttribute("someobject", "A message");
//		request.getRequestDispatcher("last").forward(request, response);
		PrintWriter out = response.getWriter();
		out.append("<html><head><title>First Page</title></head><body><h1>Last Point in the work flow!</h1><p>");
		out.append("<h3>Books: </h3>");
		List<String> books = (List<String>) request.getAttribute("books");
		if (books == null || books.size() == 0) {
			out.append("No books found!");
		} else {
			out.append("<ul>");
			for (String b : books) {
				out.append("<li>");
				out.append(b.toString());
				out.append("</li>");
			}
			out.append("</ul>");
			out.append(request.getParameter("term"));
			out.append("</p></body></html>");
		}
	}

}
