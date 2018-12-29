package businessLogic;

import dao.interfaces.generic.ICreatable;
import model.Author;
import model.Book;

public class AdminBookAuthorBusinessLogic {

	private ICreatable<Book> createBookDao;
	
	public Book createBook(String name, String desc, Author... authors) {
		Book b = new Book();
		b.setName(name);
		b.setDesc(desc);
		for(Author a : authors)
			b.addAuthor(a);
		
		createBookDao.create(b);
		
		return b;
	}

	public boolean batchCreateBooks(Book... books) {
		return false;
	}

	public Author createAuthor(String name, String desc) {
		return null;
	}

	public boolean batchCreateAuthors(Author... authors) {
		return false;
	}
}
