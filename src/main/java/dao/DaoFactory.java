package dao;

import dao.interfaces.IAuthorDao;
import dao.interfaces.IBookDao;
import dao.interfaces.IUserDao;
import dao.jpa.JpaDaoFactory;
import model.Admin;
import model.Admin;
import model.Borrower;
import model.User;
import model.User;

public class DaoFactory {

	@SuppressWarnings("unchecked")
	public static final <T extends User> IUserDao<T> getUserDao(Class<T> clz) {
		if (clz == Borrower.class)
			return (IUserDao<T>) getBorrowerDao();
		else if (clz == Admin.class)
			return (IUserDao<T>) getAdminDao();
		else
			throw new IllegalArgumentException("Unknown type when getting a generic UserDao");
	}

	public static final IUserDao<Borrower> getBorrowerDao() {
		return JpaDaoFactory.getBorrowerDao();
	}

	public static final IUserDao<Admin> getAdminDao() {
		return JpaDaoFactory.getAdminDao();
	}

	public static final IBookDao getBookDao() {
		return JpaDaoFactory.getBookDao();
	}
 
	public static final IAuthorDao getAuthorDao() {
		return JpaDaoFactory.getAuthorDao();
	}
}
