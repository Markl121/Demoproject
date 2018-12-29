package businessLogic;

import dao.interfaces.generic.Authenticator;
import exceptions.UserDataException;

import model.User;

public class AuthenticationBusinessLogic<T extends User> {

                // @Resource(name='userDao')
                private Authenticator<T> authDao;
                private Class<T> clz;

                public AuthenticationBusinessLogic(Class<T> clz) {
                                super();
                                this.clz = clz;
                }

                public void setAuthDao(Authenticator<T> authDao) {
                                this.authDao = authDao;
                }

	public T register(String username, String password, String email) throws UserDataException {
		// case insensitive;
		// username = user.toLowerCase();
		// Validate input and process data accordingly

		// case insensitive:
		// username = username.toLowerCase();

		// Note: delegated validation to the User object itself
		T b = null;
		if (authDao.isUsernameTaken(username))
			throw new UserDataException("Username is not unique");

		// else if (!this.authDao.create(b))
		// throw new UserDataException("Error occurred when writing user to data
		// store");
		try {
			b = new Borrower().setUsername(username).setPassword(password).setEmail(email);
		} catch (RuntimeException e) {
			throw new UserDataException(e);
		}

		return b;
	}

	// if (username == null || username == "")
	// throw new UserDataException("Username must have content");
	// else if (password == null || password.length() < 6)
	// throw new UserDataException("Password must have 6 charcters");
	// else if (username.length() > 20)
	// throw new UserDataException("Username must be 20 max");
	// // use regular expressions to find the format of the username
	// else if (!username.matches("^[a-zA-Z][a-zA-Z0-9_]*$"))
	// throw new UserDataException("Username contains illegal characters");
	// else if (userDao.readByUsername(username) != null)
	// throw new UserDataException("Username is not unique");
	//
	// User u = new
	// User().setUsername(username).setPassword(password).setEmail(email).setFirstName(fristname)
	// .setLastName(lastname);
	//
	// if (!this.userDao.create(u))
	// throw new UserDataException("Error occurred when writing user to data
	// store");
	// return u;
	//
	// }

	public User login(String username, String password) {
		if (username == null || username.length() == 0 || password == null || password.length() < 6
				|| username.length() > 20)
			return null;

		User u = userDao.readByUsername(username);
		System.out.println(u);
		if (u != null && u.getPassword().equals(password))
			return u;

		return null;
	}

	public boolean changePassword(User user, String oldPw, String newPw, String confPw) {
		return false;
	}
}
