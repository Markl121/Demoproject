package dao.jpa;

import java.io.Reader;

import dao.interfaces.IUserDao;
import model.Borrower;

public class BorrowerJpaDao extends UserJpaDao<Borrower> implements IUserDao<Borrower> {

	BorrowerJpaDao() {
	}

	@Override
	public boolean delete(Borrower t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Borrower findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
