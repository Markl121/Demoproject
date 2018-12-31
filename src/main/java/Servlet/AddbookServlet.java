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
import exceptions.UserDataException;
import model.Book;
import model.User;

/**
 * Servlet implementation class AddbookServlet
 */
@WebServlet("/addbookServlet")
public class AddbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddbookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookId = request.getParameter("param1");
		UserBookBusinessLogic ubl = new UserBookBusinessLogic();
		ubl.setBookDao(JpaDaoFactory.getBookDao());
		Set<Book> list;
//		list = ubl.readAll();
		
		HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
		list = ubl.addUser(user, Integer.parseInt(bookId));

//		list = ubl.searchByName(request.getParameter("term"));

		// String[] split = request.getParameter("term").split(" ");
		//
		// List<String> list = Arrays.asList(split);

		request.setAttribute("books", list);

		request.getRequestDispatcher("myAccount.jsp").forward(request, response);
	}

}

