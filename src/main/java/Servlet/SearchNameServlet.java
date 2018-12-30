package Servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.UserBookBusinessLogic;
import dao.jpa.JpaDaoFactory;
import model.Book;
import model.User;

/**
 * Servlet implementation class FormHandling
 */
@WebServlet("/searchBookName")
public class SearchNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBookBusinessLogic ubl = new UserBookBusinessLogic();
		ubl.setBookDao(JpaDaoFactory.getBookDao());
		Set<Book> list;
//		list = ubl.readAll();
		
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
		list = ubl.findByUser(user);

//		list = ubl.searchByName(request.getParameter("term"));

		// String[] split = request.getParameter("term").split(" ");
		//
		// List<String> list = Arrays.asList(split);

		request.setAttribute("books", list);

		request.getRequestDispatcher("myAccount.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
