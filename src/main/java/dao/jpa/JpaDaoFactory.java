package dao.jpa;

import dao.interfaces.IAuthorDao;
import dao.interfaces.IBookDao;
import dao.interfaces.IUserDao;
import model.Admin;
import model.Borrower;

public class JpaDaoFactory {

	public static final IUserDao<Borrower> getBorrowerDao() {
		return new BorrowerJpaDao();
	}

	public static final IUserDao<Admin> getAdminDao() {
		return new AdminJpaDao();
	}

	public static final IBookDao getBookDao() {
		return new BookJpaDao();
	}
	
	public static final IAuthorDao getAuthorDao(){
		return new AuthorJpaDao();
	}

	private JpaDaoFactory() {
	}
}
