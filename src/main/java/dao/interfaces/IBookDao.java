package dao.interfaces;

import java.util.List;

import dao.interfaces.generic.IBatchCreate;
import dao.interfaces.generic.IReadable;
import model.Author;
import model.Book;
import model.User;

public interface IBookDao extends IBatchCreate<Book>, IReadable<Book> {

	List<Book> findByAuthor(Author author);

	List<Book> findByAuthorNameLike(String name);
	
	List<Book> findByNameLike(String name);

	Book findByIsbn(String isbn);

	List<Book> findByUser(User user);

	List<Book> addUser(User user, int id);
}
