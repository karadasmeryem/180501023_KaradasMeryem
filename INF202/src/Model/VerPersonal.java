package Model;
import DBCon.DBCon; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;  

public class VerPersonal extends Benutzer{ 

	Statement st = null ; 
	ResultSet rs = null ;  
	PreparedStatement preparedStatement = null; 
	
	
	public VerPersonal(int id , String tcno, String name, String password,String type) { 
		 super(id,tcno,name,password,type);
	}
    public VerPersonal() { }  
    
    public   ArrayList<Benutzer> getPersonalList() throws SQLException { 
    	ArrayList<Benutzer> list = new ArrayList<>();  
    	Connection con = conn.connDb();
    
    	Benutzer obj; 
    	try {
			st = con.createStatement(); 
			rs = st.executeQuery("SELECT * FROM benutzer WHERE type= 'personal'");
	        while(rs.next()) { 
	        	obj = new Benutzer(rs.getInt("id"),rs.getString("tcno"),rs.getString("name"),rs.getString("password"),rs.getString("type")); 
	        	list.add(obj);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 
    	return list;
    }   
    
    public boolean addPersonal(String tcno,String password,String name ) throws SQLException {   
    	
    	Connection con = conn.connDb();
    	String query= "INSERT INTO benutzer " + "(tcno,password,name,type) VALUES" + "(?,?,?,?)" ; 
    	boolean key = false; 
    	try {
    	st = con.createStatement(); 
    	preparedStatement = con.prepareStatement(query); 
    	preparedStatement.setString(1, tcno); 
    	preparedStatement.setString(2, password); 
    	preparedStatement.setString(3, name); 
    	preparedStatement.setString(4, "personal"); 
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
     
    /* her soru iþaretini dýþardan aldýðýn id ile deðiþtir
     */
  public boolean deletePersonal(int id ) throws SQLException {   
    	
    	Connection con = conn.connDb();
    	String query= "DELETE FROM benutzer WHERE id = ? " ; 
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
   
  public boolean updatePersonal(int id,String tcno,String password,String name ) throws SQLException {   
  	
  	Connection con = conn.connDb();
  	String query= "UPDATE benutzer SET tcno = ?,password = ?,name=? WHERE id= ? " ; 
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

