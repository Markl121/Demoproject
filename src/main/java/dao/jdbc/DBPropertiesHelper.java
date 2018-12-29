package dao.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DBPropertiesHelper {
	 
	private static Properties props;
	
	static {
		props = new Properties();
		try {
			props.load(new FileReader("dbProps.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static String getDbUrl(){
		//return "jdbc:oracle:thin:@localhost:1521:xe";
		return props.getProperty("dbUrl");
	}

	static String getDbUname() {
		// TODO Auto-generated method stub
		//return "trainee1";
		return props.getProperty("dbUname");
	}

	static String getDbPassword() {
		// TODO Auto-generated method stub
		//return "!QAZSE4";
		return props.getProperty("dbPwd");
	}

}
