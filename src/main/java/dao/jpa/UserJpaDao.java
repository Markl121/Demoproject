package dao.jpa;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import dao.interfaces.IUserDao;
import exceptions.UserDataException;
import model.User;
import model.UserStatus;

public abstract class UserJpaDao<T extends User> implements IUserDao<T> {

	@SuppressWarnings("unchecked")
	private final Class<T> clz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	UserJpaDao() {
	}
	@Override
	public boolean create(T t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean update(T t) {
		EntityManager em = EMFactory.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

//	@Override
//	public boolean delete(T t) {
//
//		t.setUserStatus(UserStatus.DELETED);
//		return update(t);
//	}

	@Override
	public T readByUsername(String username) {
		String queryName = String.format("%s.byUsername", clz.getSimpleName());

		EntityManager em = EMFactory.getEntityManager();
		T user = null;
		try {
			user = em.createNamedQuery(queryName, clz).setParameter("uname", username).getSingleResult();
		} catch (NoResultException e) {
		}
		em.close();
		return user;
	}

//	@Override
//	public T readByEmail(String email) {
//		// I'm breaking the rule here just to demonstrate the second approach
//		String query = String.format("select a from %s a where a.email = :email", this.clz.getSimpleName());
//		EntityManager em = EMFactory.getEntityManager();
//		T user = em.createQuery(query, clz).setParameter("email", email).getSingleResult();
//		em.close();
//		return user;
//	}
	@Override
	public T register(T t) {

		if (create(t))
			return t;

		return null;
	}

	@Override
	public T login(String username, String password, String type) {
		String queryName = String.format("%s.login", clz.getSimpleName());

		EntityManager em = EMFactory.getEntityManager();
		T user = null;
		try {
			user = em.createNamedQuery(queryName, clz).setParameter("uname", username).setParameter("pw", password)
					.getSingleResult();

		} catch (NoResultException e) {
			user = null;
		}
		em.close();
		return user;
	}

	@Override
	public boolean changePassword(T t, String oldPassword, String newPassword) {
		T found = login(t.getUsername(), oldPassword, "User");
		if (found != null) {
			try {
				found.setPassword(newPassword);
			} catch (UserDataException e) {
				e.printStackTrace();
			}
			return update(found);
		}
		return false;
	}

	@Override
	public boolean isUsernameTaken(String username) {
		return readByUsername(username) != null;
	}

}
