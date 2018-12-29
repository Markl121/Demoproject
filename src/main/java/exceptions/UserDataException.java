package exceptions;

public class UserDataException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -964930201956523873L;

	public UserDataException() {
		super();
	}

	public UserDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserDataException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDataException(String message) {
		super(message);
	}

	public UserDataException(Throwable cause) {
		super(cause);
	}

	
}
