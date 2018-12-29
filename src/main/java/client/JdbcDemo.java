package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		String brokerSelectQuery = " select broker_id, first_name,last_name from broker";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUname = "trainee1";
		String dbPw = "!QAZSE4";

		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(url, dbUname, dbPw);
		Statement st = conn.createStatement();
		ResultSet rst = st.executeQuery(brokerSelectQuery);
		

		while (rst.next()) {
			int id = rst.getInt("broker_id");
			String fName = rst.getString("first_name");
			String lName = rst.getString("last_name");

			System.out.println(String.format("%d - %s %s", id, fName, lName));
		}

		rst.close();
		st.close();
		conn.close();

		
		
		System.out.println("Finished");
	}

}
