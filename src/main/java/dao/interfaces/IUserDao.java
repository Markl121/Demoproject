package dao.interfaces;

import dao.interfaces.generic.Authenticator;
import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IDeletable;
import dao.interfaces.generic.IUpdatable;
import model.User;

public interface IUserDao<T extends User> extends  ICreatable<T>, IDeletable<T>,IUpdatable<T>, Authenticator<T> {

	T readByUsername(String username);
	T findByEmail(String email);
}
