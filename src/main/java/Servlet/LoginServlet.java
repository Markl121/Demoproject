package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.interfaces.IUserDao;
import model.Admin;
import model.Borrower;
import model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("solo.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pw = request.getParameter("password");
		String type = request.getParameter("type");

		Class<? extends User> userType = null;
		if (type.equals("Reader"))
			userType = Borrower.class;
		else if (type.equals("Admin"))
			userType = Admin.class;
		else
			throw new ServletException("Unrecognised User type when logging in");

		IUserDao<? extends User> dao = DaoFactory.getUserDao(userType);
		User loggedInUser = dao.login(uname, pw, type);

		if (loggedInUser == null) {
			response.sendRedirect("login.jsp?err=1");
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("user", loggedInUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("solo.jsp");
		//request.getRequestDispatcher(type.toLowerCase() + "solo.jsp").forward(request, response);
		//session.getAttribute(type);
		dispatcher.forward(request, response);
	}

}
