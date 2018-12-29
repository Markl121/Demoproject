package dao.interfaces;

import java.util.List;

import dao.interfaces.generic.ICreatable;
import dao.interfaces.generic.IReadable;
import model.Author;

public interface IAuthorDao extends ICreatable<Author>, IReadable<Author> {

	Author readByName(String name);
	
	List<Author> readByNameLike(String name);
}
