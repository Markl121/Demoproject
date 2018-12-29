package dao.jpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import dao.DaoFactory;
import dao.interfaces.IBookDao;
import model.Author;
import model.Book;

public class BookJpaDao implements IBookDao {

	BookJpaDao() {
	}

	@Override
	public boolean batchCreate(Book... ts) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();

		for (Book b : ts) {
			// attach author objects to EM so that we do not duplicate data in
			// the Authors table
			Set<Author> attachedAuthors = new HashSet<>();
			for (Author a : b.getAuthors()) {
				Author author = em.createNamedQuery("Author.byName", Author.class).setParameter("name", a.getName())
						.getSingleResult();
				// If author is null, this is a new Author
				if (author == null) {
					em.persist(a);
					attachedAuthors.add(a);
				} else
					attachedAuthors.add(author);
			}
			b.setAuthors(attachedAuthors);

			em.persist(b);

		}

		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean create(Book t) {
		return batchCreate(t);
	}

	@Override
	public List<Book> readAll() {
		String query = "Book.all";// "select b from Book b";

		EntityManager em = EMFactory.getEntityManager();
		List<Book> list = em.createNamedQuery(query, Book.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Book readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Book book = em.find(Book.class, id);
		em.close();

		return book;
	}

	@Override
	public List<Book> findByNameLike(String name) {
		String queryName = "Book.byNameLike";
		EntityManager em = EMFactory.getEntityManager();
		List<Book> list = em.createNamedQuery(queryName, Book.class).setParameter("str", "%" + name + "%")
				.getResultList();
		em.close();

		return list;
	}

	@Override
	public List<Book> findByAuthor(Author author) {
		String query = "Book.byAuthor";

		EntityManager em = EMFactory.getEntityManager();
		// Check input author in the data store, attach Author to EntityManager
		// - just retrieving it and having the entity's id is ok
		author = new AuthorJpaDao().readByName(author.getName());
		// author = em.createNamedQuery("Author.byName",
		// Author.class).setParameter("name", author.getName())
		// .getSingleResult();

		// If the author is null, then clearly there won't be any books by them
		// anyway
		if (author == null)
			return null;

		List<Book> list = em.createNamedQuery(query, Book.class).setParameter("author", author).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Book> findByAuthorNameLike(String name) {
		List<Author> authors = DaoFactory.getAuthorDao().readByNameLike(name);

		if (authors == null || authors.size() == 0)
			return null;

		EntityManager em = EMFactory.getEntityManager();
		String queryName = "Book.byAuthor";

		List<Book> list = em.createNamedQuery(queryName, Book.class).setParameter("author", authors).getResultList();
		em.close();

		return list;
	}

	@Override
	public Book findByIsbn(String isbn) {
		String queryName = "Book.byIsbn";
		EntityManager em = EMFactory.getEntityManager();
		Book book = em.createNamedQuery(queryName, Book.class).setParameter("isbn", isbn).getSingleResult();
		em.close();
		return book;
	}
}
