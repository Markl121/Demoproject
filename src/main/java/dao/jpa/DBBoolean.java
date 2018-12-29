package dao.jpa;

public enum DBBoolean {
	TRUE, FALSE;
	
	public static boolean convert(DBBoolean bool){
		return bool == TRUE;
	}
	public static DBBoolean convert(boolean bool){
		return bool ? TRUE : FALSE;
	}

}
