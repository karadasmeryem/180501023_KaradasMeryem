package Versicherung_System;   

import java.sql.DriverManager;
import com.mysql.cj.jdbc.ConnectionWrapper;
import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Connection;


public class Database { 
	 
private static final String DriverManager = null;

public static void main(String[] args ) {  
	try { 
		ConnectionWrapper myConn = (Connection) DriverManager.getConnection("jdbc:mysql:localhost:3306/data","root","123456");
	 Statement myStat = (Statement) myConn.createStatement (); 
	 ResultSet MyRs = mStat.executeQuery("select * from kunden"); 
	 while(myRs.next()) { 
		 System.out.printIn(myRs.getString("vorname") + "-" + myRs.getString("nachname")+ "-"  
				 + myRs.getString("geschlecht")+ "-" +myRs.getString("ID")+ "-" +myRs.getString("email")+ "-" 
				 + myRs.getString("kundennummer")+ "-" +myRs.getString("telefonnummer"));
	 }
	} catch (Exception e) { 
		e.printStackTrace();

		}
	}

}
