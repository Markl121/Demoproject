package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.AuthenticationBusinessLogic;
import dao.DaoFactory;
import dao.interfaces.IUserDao;
import dao.jpa.JpaDaoFactory;
import exceptions.UserDataException;
import model.Admin;
import model.Borrower;
import model.User;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.sendRedirect("solo.jsp");
    }
/*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String type = request.getParameter("type");
	
		Class<? extends User> userType = null;
		 if (type.equals("Reader"))
		 {
		 	userType = Borrower.class;
		 }
		 else if (type.equals("Admin"))
		 	userType = Admin.class;
		 else
		 	throw new ServletException("Unrecognised User type when logging in");
		
		AuthenticationBusinessLogic<Borrower> abl =new AuthenticationBusinessLogic<>(Borrower.class);
		abl.setAuthDao(JpaDaoFactory.getBorrowerDao());
		try{
			abl.register(username, password, email);
			
		}catch(UserDataException e){
			HttpSession session =request.getSession();
			session.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("Register.jsp?err=1").forward(request, response);
			return;
		}
		// Class<? extends User> userType = null;
		// Borrower user;
		// if (type.equals("Reader"))
		// {
		// 	userType = Borrower.class;
		// 	user = new Borrower();
		// 	user.setEmail(email);
		// 	user.setPassword(password);
		// 	user.setUsername(username);
		// }
		// else if (type.equals("Admin"))
		// 	userType = Admin.class;
		// else
		// 	throw new ServletException("Unrecognised User type when logging in");

		// IUserDao<? extends User> dao = DaoFactory.getUserDao(userType);
		
		// User loggedInUser = dao.register(user);
		
		request.getRequestDispatcher("solo.jsp?register=1").forward(request, response);
	}
}

