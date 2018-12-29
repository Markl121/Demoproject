package dao.interfaces.generic;

import model.IStorable;

public interface IBatchCreate<T extends IStorable> extends ICreatable<T> {

	@SuppressWarnings("unchecked")
	boolean batchCreate(T... ts);

}
