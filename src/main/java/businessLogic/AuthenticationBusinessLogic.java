package businessLogic;

import dao.interfaces.IUserDao;
import dao.interfaces.generic.Authenticator;
import exceptions.UserDataException;
import model.Admin;
import model.Borrower;

import model.User;

public class AuthenticationBusinessLogic < T extends User > {

	private Authenticator < T > authDao;

	private Class < T > clz;

	public AuthenticationBusinessLogic(Class < T > clz) {

		super();

		this.clz = clz;

	}

	public void setAuthDao(IUserDao<? extends User> iUserDao) {

		this.authDao = (Authenticator<T>) iUserDao;

	}

	public T register(String username, String password, String email, String type)

	throws UserDataException {

		T t = getUserSubtype();

		if (authDao.isUsernameTaken(username)) {

			throw new UserDataException("Error: Username is not unique");

		}  else if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {

			throw new UserDataException("Error: Please fill in all fields");

		}

		try {

			t.setUsername(username).setPassword(password).setEmail(email);

			t = authDao.register(t);

		} catch (RuntimeException e) {

			throw new UserDataException("Could not register user. Please try again.");

		}

		return t;

	}



	public T login(String username, String password, String type) {

		if (username == null || username.length() == 0 || username.length() > 20 || password.length() == 0

			||
			password == null || password.length() < 6) {

			return null;

		}

		return authDao.login(username, password, type);

	}



	public boolean changePassword(String username, String oldPW, String newPW, String confPW) {

		return false;

	}

	@SuppressWarnings("unchecked")

	private T getUserSubtype() {

		if (clz == Borrower.class)

			return (T) new Borrower();

		else if (clz == Admin.class)

			return (T) new Admin();

		else

			throw new IllegalArgumentException("Invalid User subtype");

	}

}
