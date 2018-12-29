package Servlet;

import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FromHandle
 */
@WebServlet("/FromHandle")
public class FromHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public FromHandle() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
//		out.append("<html><head><title>First Page</title></head><body><h1>Servlet Text Handing Webpage</h1><p>");
//		out.append("<h3> Your message</h3>");
//		out.append(request.getParameter("someText"));
//		out.append("<h3>Message from the atributes:</h3>");
//		out.append(request.getAttribute("someobject").toString());
//		out.append("</p></body></html>");
		response.sendRedirect("firstServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//request.getRequestDispatcher("handle").forward(request, response);
		String[] split = request.getParameter("term").split(" ");
		List<String> list = Arrays.asList(split);
		request.setAttribute("books", list);
		request.getRequestDispatcher("listOutput.jsp").forward(request, response);

	}

}
