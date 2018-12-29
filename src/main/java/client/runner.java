package client;
import exceptions.UserDataException;
import model.User;
public class runner {
	 public static void main(String[] args) throws UserDataException{
		 User u = new User()
				 .setUsername("sd")
		 		 .setPassword("sa")
		 		 .setEmail("uhi@.com")
		 		 .setFirstName("ad")
		 		 .setLastName("awe");
		 System.out.println(u);
	 }
}
