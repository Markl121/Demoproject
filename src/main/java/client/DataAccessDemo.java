package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exceptions.UserDataException;
import model.Admin;
import model.Author;
import model.Book;
import model.Borrower;
import model.User;

	public class DataAccessDemo {
	public static void main(String[] args) throws UserDataException {
		
		
		
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Demoproject");
		EntityManager em = emf.createEntityManager();
		User newJoe = new User().setId(0).setUsername("joejoe")
					.setPassword("123456").setFirstName("Joe")
					.setLastName("Joejoeson").setEmail("joejoe@bob.com");

		Admin newAdmin = new Admin();; 
		newAdmin.setId(0).setUsername("Admin")
					.setPassword("123456").setFirstName("Admin")
					.setLastName("Joejoeson").setEmail("joejoe@bob.com");

		Borrower newshanshan = new Borrower();
		newshanshan.setId(0).setUsername("shanshan")
					.setPassword("123456").setFirstName("shanshan")
					.setLastName("Gu").setEmail("joejoe@bob.com");
		
		Author newauth = new Author();
		newauth.setDesc("desc").setName("Shanshan");
		
		Book newbook = new Book();
		newbook.setName("shanshan")
					.setIsbn("123456").setDesc("shanshan")
					.setImgUrl("http://placeimg.com/640/480/people").addAuthor(newauth).addUser(newshanshan);
		
		em.getTransaction().begin();
		em.persist(newJoe);
		em.persist(newAdmin);
		em.persist(newshanshan);
		em.persist(newauth);
		em.persist(newbook);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
//		IUserDao userDao = DaoFactory.getUserDao();
//		
//		User newJoe = new User().setUsername("joejoe").setPassword("123456").setFirstName("Joe").setFirstName("Joejoeson").setEmail("joejoe@bob.com"); 
//		
//		System.out.println(newJoe);
//		
//		userDao.create(newJoe);
//		
//		List<User> list = userDao.readByFirstname("Joe");
//		for (User u : list)
//			System.out.println(u);
//
//		System.out.println("Finished");

	}
}
