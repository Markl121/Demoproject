package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessLogic.AuthenticationBusinessLogic;
import model.Borrower;


@WebServlet("/RegisterServlet")
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
		String uname = request.getParameter("username");
		String pw = request.getParameter("password");
		String type = request.getParameter("type");
	
		
		AuthenticationBusinessLogic<Borrower> abl =new AuthenticationBusinessLogic<>(Borrower.class);
		abl.setAuthDao(JpaFactory.getBorrower());
		try{
			abl.register(username,password,email);
			
		}catch(UserDatatException e){
			HttpSession session =request.getSession();
			session.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("register.jsp?err=1").forward(request, response);
			return;
		}
		
	}
	request.getRequestDispatcher("solo.jsp?register=1").forward(request, response);
}
