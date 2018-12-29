package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import dao.jpa.DBBoolean;
import exceptions.UserDataException;

@Entity
@Table(name = "Readers")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING, length = 10)
public class User implements IStorable, Serializable {

	private static final long serialVersionUID = 7583733460111899831L;
	@Id
	@Column(name = "userId")
	@GeneratedValue(generator = "seq_userId")
	@SequenceGenerator(name = "seq_userId", sequenceName = "seq_userId", initialValue = 1, allocationSize = 1)
	// add a definition for a sequence
	private int id;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(name = "pw", nullable = false)
	private String password;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 40)
	private String email;

	@Enumerated(EnumType.STRING)
	@Column
	private DBBoolean active;

	public boolean isActive() {
		return DBBoolean.convert(active);
	}

	public User setActive(boolean active) {
		this.active = DBBoolean.convert(active);
		return this;
	}

	public User() {

	}

	public int getId() {
		return id;
	}

	public User setId(int id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;

	}

	public User setUsername(String username) throws UserDataException {
		// if (username == null || username.length() == 0)
		// throw new UserDataException("Username must a value");
		// this.username = username;
		// return this;
		if (username == null || username == "")
			throw new IllegalArgumentException("Username must have content");
		else if (username.length() > 20)
			throw new IllegalArgumentException("Username must be 20 chars max");
		else if (!username.matches("^[a-zA-Z][a-zA-Z0-9_]*$"))
			throw new IllegalArgumentException("Username contains illegal characters");
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) throws UserDataException {
		if (password == null || password.length() == 0)
			throw new UserDataException("password must have at least 6 characters");
		this.password = password;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}

}
