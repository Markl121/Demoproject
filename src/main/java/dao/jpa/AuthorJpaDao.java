package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import dao.interfaces.IAuthorDao;
import model.Author;

public class AuthorJpaDao implements IAuthorDao {

	AuthorJpaDao() {
	}

	@Override
	public boolean create(Author t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public List<Author> readAll() {
		EntityManager em = EMFactory.getEntityManager();

		List<Author> list = em.createNamedQuery("Author.all", Author.class).getResultList();
		em.close();
		return list;
	}

	@Override
	public Author readById(int id) {
		EntityManager em = EMFactory.getEntityManager();
		Author author = em.find(Author.class, id);
		em.close();

		return author;
	}

	@Override
	public Author readByName(String name) {
		EntityManager em = EMFactory.getEntityManager();

		Author author = em.createNamedQuery("Author.byName", Author.class).setParameter("name", name).getSingleResult();
		em.close();
		return author;
	}

	@Override
	public List<Author> readByNameLike(String name) {
		EntityManager em = EMFactory.getEntityManager();

		List<Author> list = em.createNamedQuery("Author.byNameLike", Author.class)
				.setParameter("name", "%" + name + "%").getResultList();
		em.close();
		return list;
	}

}
