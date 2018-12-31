package businessLogic;

import java.util.Set;

import model.Book;
import model.Borrower;
import model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dao.interfaces.IBookDao;
import model.Book;

public class UserBookBusinessLogic {

	private IBookDao bookDao;

	public void setBookDao(IBookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public Set<Book> readAll(){
		return new HashSet<>(bookDao.readAll());
	}

	public Set<Book> searchByName(String name) {
		return new HashSet<>(bookDao.findByNameLike(name));
	}

	public Set<Book> searchByAuthor(String authorName) {
		return null;
	}

	public Set<Book> findByUser(User user) {
		return new HashSet<>(bookDao.findByUser(user));
	}

	public Set<Book> addUser(User user, int id) {
		return new HashSet<>(bookDao.addUser(user, id));
	}

}