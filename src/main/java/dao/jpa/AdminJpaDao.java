package dao.jpa;

import model.Admin;

public class AdminJpaDao extends UserJpaDao<Admin> {

	AdminJpaDao() {
	}

	@Override
	public Admin findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Admin t) {
		// TODO Auto-generated method stub
		return false;
	}
}
