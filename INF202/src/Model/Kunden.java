package Model; 
import DBCon.DBCon; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;  


public class Kunden extends Benutzer{   
	Statement st = null ; 
	ResultSet rs = null ;  
	PreparedStatement preparedStatement = null;  
	
	public Kunden(int id , String tcno, String name, String password,String type) { 
		 super(id,tcno,name,password,type);
	}
   public Kunden() { }   
    
   public   ArrayList<Kunden> getPersonalList() throws SQLException { 
   	ArrayList<Kunden> list = new ArrayList<>();  
   	Connection con = conn.connDb();
   
   	Kunden obj; 
   	try {
			st = con.createStatement(); 
			rs = st.executeQuery("SELECT * FROM kunden ");
	        while(rs.next()) { 
	        	obj = new Kunden(rs.getInt("id"),rs.getString("tcno"),rs.getString("name"),rs.getString("password"), name); 
	        	list.add(obj);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	 
   	return list;
   }    
   
public boolean addKunden(String tcno,String password,String name ) throws SQLException {   
    	
    	Connection con = conn.connDb();
    	String query= "INSERT INTO kunden " + "(tcno,password,name) VALUES" + "(?,?,?)" ; 
    	boolean key = false; 
    	try {
    	st = con.createStatement(); 
    	preparedStatement = con.prepareStatement(query); 
    	preparedStatement.setString(1, tcno); 
    	preparedStatement.setString(2, password); 
    	preparedStatement.setString(3, name); 
    	preparedStatement.executeUpdate(); 
    	key = true;
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	 
    	if(key) 
    		return true; 
    	else  
    		return false;
    }    
public boolean deleteKunden(int id ) throws SQLException {   
	
	Connection con = conn.connDb();
	String query= "DELETE FROM kunden WHERE id = ? " ; 
	boolean key = false; 
	try {
	st = con.createStatement(); 
	preparedStatement = con.prepareStatement(query); 
	preparedStatement.setInt(1, id); 
	preparedStatement.executeUpdate(); 
	key = true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	if(key) 
		return true; 
	else  
		return false;
}  

public boolean updateKunden(int id,String tcno,String password,String name ) throws SQLException {   
	
	Connection con = conn.connDb();
	String query= "UPDATE kunden SET tcno = ?,password = ?,name=? WHERE id= ? " ; 
	boolean key = false; 
	try {
	st = con.createStatement(); 
	preparedStatement = con.prepareStatement(query); 
	preparedStatement.setString(1, tcno);  
	preparedStatement.setString(2, password);  
	preparedStatement.setString(3, name);  
	preparedStatement.setInt(4, id); 
	preparedStatement.executeUpdate(); 
	key = true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	 
	if(key) 
		return true; 
	else  
		return false;
} 

}
