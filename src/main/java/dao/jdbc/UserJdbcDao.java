package dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.interfaces.IUserDao;
import model.User;

public class UserJdbcDao implements IUserDao {

	@Override
	public List<User> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(User t) {
		// TODO Auto-generated method stub
		final String sql = "INSERT INTO tblUsers (userId, username, password, firstname, lastname, email)"
				+ "(VALUES (seq_userId.nextVal, ?, ?, ?, ?, ?)";
		try(DataAccessLayer dal = new DataAccessLayer()) {
			return dal.doTableUpdate(sql, t.getUsername(), t.getPassword(), t.getFirstName(), t.getFirstName(),
			t.getEmail()) == 1;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delect(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User readByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> readByFirstname(String firstname) {
		// TODO Auto-generated method stub
		String brokerSelectQuery = "SELECT BROKER_ID, FIRST_NAME, LAST_NAME FROM BROKER WHERE FIRST_NAME = ?";

		try (DataAccessLayer dal = new DataAccessLayer()){
			List<User> users = new ArrayList<>();
			ResultSet rst = dal.doSelectQuery(brokerSelectQuery, firstname);
			while(rst.next()){
				User u = new User().setId(rst.getInt(1)).setFirstName(rst.getString(2)).setLastName(rst.getString(3));
				users.add(u);
			}
			return users;
		} catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}



}
