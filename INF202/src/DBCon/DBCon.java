package  DBCon;  
import java.sql.*;
 public class DBCon { 
	 
	Connection c = null;
	public  DBCon() {
	}

	public Connection connDb() throws SQLException {
		try {
	 this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/versicherung?user=root&password=your_new_password") ;
	 return c;
		} catch (Exception e) {
			e.printStackTrace(); 
			
		}

		return c;
	}
}