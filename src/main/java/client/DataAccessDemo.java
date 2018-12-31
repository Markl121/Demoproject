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
		
		Book newbook1 = new Book();
		newbook1.setName("shanshan")
					.setIsbn("123456").setDesc("the couple next door")
					.setImgUrl("http://placeimg.com/640/485").addAuthor(newauth);
		
		Book newbook2 = new Book();
		newbook2.setName("shanshan")
					.setIsbn("1234567").setDesc("before we were yours")
					.setImgUrl("http://placeimg.com/640/480/people").addAuthor(newauth);
		
		Book newbook3 = new Book();
		newbook3.setName("shanshan")
					.setIsbn("12345678").setDesc("detour")
					.setImgUrl("http://placeimg.com/640/481").addAuthor(newauth);
		
		Book newbook4 = new Book();
		newbook4.setName("shanshan")
					.setIsbn("123456789").setDesc("clean burn")
					.setImgUrl("http://placeimg.com/640/482").addAuthor(newauth);
		
		Book newbook5 = new Book();
		newbook5.setName("shanshan")
					.setIsbn("1234567890").setDesc("there there")
					.setImgUrl("http://placeimg.com/640/483").addAuthor(newauth);
		
		Book newbook6 = new Book();
		newbook6.setName("shanshan")
					.setIsbn("12345678901").setDesc("circe")
					.setImgUrl("http://placeimg.com/640/484").addAuthor(newauth);
		
		
		
		em.getTransaction().begin();
		em.persist(newJoe);
		em.persist(newAdmin);
		em.persist(newshanshan);
		em.persist(newauth);
		em.persist(newbook1);
		em.persist(newbook2);
		em.persist(newbook3);
		em.persist(newbook4);
		em.persist(newbook5);
		em.persist(newbook6);
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
