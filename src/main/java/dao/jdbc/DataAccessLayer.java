package dao.jdbc;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import oracle.jdbc.OracleDriver;

public class DataAccessLayer implements AutoCloseable{

	private static final String URL;
	private static final String DBUNAME;
	private static final String DBPWD;
	
	static {
		try {
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		URL = DBPropertiesHelper.getDbUrl();
		DBUNAME = DBPropertiesHelper.getDbUname();
		DBPWD = DBPropertiesHelper.getDbPassword();
			
	}
	
	private Connection conn;
	private Statement st;
	private ResultSet rst;
	
	//constructor has default(package-private) visibility
	public DataAccessLayer() throws SQLException{
		conn = DriverManager.getConnection(URL, DBUNAME, DBPWD);
	}
	
	public int doTableUpdate(String sql, Object... args) throws SQLException{
		PreparedStatement pst = createPreparedStatement(sql, args);
		return pst.executeUpdate();
	}
	
	public ResultSet doSelectQuery(String sql, Object... args) throws SQLException{
		PreparedStatement pst = createPreparedStatement(sql, args);
		rst = pst.executeQuery();
		return rst;
	}
	
	private PreparedStatement createPreparedStatement(String sql, Object... args) throws SQLException{
		PreparedStatement pst = conn.prepareStatement(sql);
		int counter = 0;
		for(Object o : args){
			if( o instanceof Integer){
				pst.setInt(++counter, (int) o);
			}
			else if (o instanceof String){
				pst.setString(++counter, (String) o);
			}
			else if (o instanceof Double){
				pst.setDouble(++counter, (double) o);
			}
			else if (o instanceof LocalDate){
				LocalDate ld = (LocalDate) o;
				java.sql.Date date = Date.valueOf(ld);
				pst.setDate(++counter,  date);
			}
			else if (o instanceof LocalDateTime){
				LocalDateTime ldt = (LocalDateTime) o;
				java.sql.Timestamp ts = Timestamp.valueOf(ldt);
				pst.setTimestamp(++counter,  ts);
			}
			else {
				throw new IllegalArgumentException("Unkown Data Type When Assignning Args to PreparedStatement: " + o.getClass());
			}
		}
		st = pst;
		return pst;
	}
	
	public void close() throws SQLException{
		if(rst != null && !rst.isClosed()){
			rst.close();
		} 
		if (st != null && !st.isClosed()){
			st.close();
		}
		if(!conn.isClosed()){
			conn.close();
		}
	}
}


