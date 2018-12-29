package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class JdbcSetupMain {	

	private static final String[] queries = { "drop table readers cascade CONSTRAINTS", "drop sequence seq_readerId",
			"create table readers (readerId number(5) primary key, username varchar2(20) unique not null, pw varchar2(255) not null, firstname varchar2(20), lastname varchar2(20), email varchar2(40) unique)",
			"create sequence seq_readerId start with 1 increment by 1",

			"begin " + "insert into readers values (seq_readerId.nextval, 'bob','123456','Bob','Bobson','bob@bob.com');"
					+ "insert into readers values (seq_readerId.nextval, 'jim','123456','Jim','Jimson','jim@jim.com');"
					+ "insert into readers values (seq_readerId.nextval, 'dave','123456','Dave','Davison','dave@dave.com');"
					+ "insert into readers values (seq_readerId.nextval, 'ed','123456','Ed','Edison','ed@ed.com');"
					+ "insert into readers values (seq_readerId.nextval, 'joe','123456','Joe','Joeson','joe@joe.com');"
					+ "insert into readers values (seq_readerId.nextval, 'bert','123456','Bert','Bertson','bert@bert.com');"
					+ "commit;" + "end;",

			"create or replace procedure createUser(" + "p_username IN Readers.username%type, "
					+ "p_password IN Readers.pw%type," + "p_firstname IN Readers.firstname%type,"
					+ "p_lastname IN Readers.lastname%type, " + "p_email IN Readers.email%type, " + "p_id OUT number"
					+ ") as begin " + "select seq_readerId.nextval into p_id from dual;"
					+ "insert into readers values (p_id, p_username,p_password,p_firstname,p_lastname,p_email);"
					+ "commit;" + "end;"

	};

	public static void main(String[] args) throws SQLException {
		DriverManager.registerDriver(new OracleDriver());
		Connection conn = DriverManager.getConnection(DBPropertiesHelper.getDbUrl(), DBPropertiesHelper.getDbUname(),
				DBPropertiesHelper.getDbPassword());

		for (String s : queries) {
			Statement st = conn.createStatement();
			try {
				st.execute(s);
				System.out.println("Query completed: " + s);
			} catch (SQLException e) {
				System.err.println("Query failed: " + s);
				System.err.println(e.getMessage());
			}
			st.close();
		}

		conn.close();
		System.out.println("Finished");
	}

}
