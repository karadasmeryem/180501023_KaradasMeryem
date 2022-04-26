package Versicherung_System;   

import java.sql.DriverManager;
import com.mysql.cj.jdbc.ConnectionWrapper;
import com.mysql.cj.xdevapi.Statement;



public class Database { 
	 
private static final String DriverManager = null;

public static void main(String[] args ) {  
	try { 
		ConnectionWrapper myConn = (ConnectionWrapper) DriverManager.getConnectionWrapper("jdbc:mysql:localhost:3306/data","root","123456");
	 Statement myStat = (Statement) myConn.createStatement (); 
	 ResultSet MyRs = mStat.executeQuery("select * from kunden"); 
	 while(MyRs.next()) { 
		 System.out.printIn(MyRs.getString("vorname") + "-" + MyRs.getString("nachname")+ "-"  
				 + MyRs.getString("geschlecht")+ "-" +MyRs.getString("ID")+ "-" +MyRs.getString("email")+ "-" 
				 + MyRs.getString("kundennummer")+ "-" +MyRs.getString("telefonnummer"));  
		 
		 ResultSet MyRs = mStat.executeQuery("select * from personel"); 
		 while(MyRs.next()) { 
			 System.out.printIn(MyRs.getString("Vorname") + "-" + MyRs.getString("Nachname")+ "-"  
					 + MyRs.getString("Geschlecht")+ "-" +MyRs.getString("PersonalID")+ "-" +MyRs.getString("arbeitsanfangsdatuml")+ "-" 
					 + MyRs.getString("Personalnummer")+ "-" +MyRs.getString("Maklergebühr"));  
			 
		 ResultSet MyRs = mStat.executeQuery("select * from verkaufer"); 
		 while(MyRs.next()) { 
			 System.out.printIn(MyRs.getString("vorname") + "-" + MyRs.getString("nachname")+ "-"  
					 + MyRs.getString("geschlecht")+ "-" +MyRs.getString("adresse")+ "-" +MyRs.getString("email")+ "-" 
					 + MyRs.getString("kundennummer")+ "-" +MyRs.getString("telefonnummer")); 
			 
	} 
		 
	} catch (Exception e) { 
		e.printStackTrace();

		}
	}

}
