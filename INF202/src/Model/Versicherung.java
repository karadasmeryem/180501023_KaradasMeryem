package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;   

import DBCon.DBCon;

public class Versicherung {   
	
	private int id; 
	private String name;
	private DBCon conn;
	private PreparedStatement preparedStatement; 
	 
	/*bos constructor */
	public Versicherung () {} 
	
	public Versicherung(int id, String name) {   
		 
		DBCon conn = new DBCon (); 
		Statement st = null ; 
		ResultSet rs = null ;  
		PreparedStatement preparedStatement = null; 
		
		this.id = id;
		this.name = name;
	} 
	 public   ArrayList<Versicherung> getVersicherungList() throws SQLException { 
	    	ArrayList<Versicherung> list = new ArrayList<>();  
	    	DBCon conn = new DBCon ();
			Connection con = conn.connDb();
	    
	    	Versicherung obj; 
	    	try { 
	    		Statement st = null ; 
	    		ResultSet rs = null ;
				st = con.createStatement(); 
				rs = st.executeQuery("SELECT * FROM versich ");
		        while(rs.next()) { 
		        	obj = new Versicherung (); 
		        	obj.setId(rs.getInt("id"));  
		        	obj.setName(rs.getString("name"));  
		        	list.add(obj);
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally { 
				con.close(); 
			}
	    	 
	    	return list;
	    }     
    public static Versicherung getFetch(int id)  {  
    	DBCon conn = new DBCon ();
    	Connection con = null;
		try {
			con = conn.connDb();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
    	Versicherung v = new Versicherung();
    	try { 
    	Statement st = null ; 
		ResultSet rs = null ;  
		st = con.createStatement();  
    	rs = st.executeQuery("SELECT * FROM versich WHERE id= " + id); 
    	while(rs.next()) {  
    		v.setId(rs.getInt("id")); 
    		v.setName(rs.getString("name"));
    	}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
		return v; 
    	
    }
	 
	 public boolean addVersicherung(String name ) throws SQLException {   
	    	
	    	Connection con = conn.connDb();
	    	String query= "INSERT INTO versich " + "(name) VALUES" + "(?)" ; 
	    	boolean key = false; 
	    	try { 
	    	    Statement st = null ; 
	    	    st = con.createStatement(); 
	    	    preparedStatement = con.prepareStatement(query); 
	    	    preparedStatement.setString(1, name); 
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
	 public boolean deleteVersicherung(int id ) throws SQLException {   
	    	
	    	Connection con = conn.connDb();
	    	String query= "DELETE FROM versich WHERE id = ? " ; 
	    	boolean key = false; 
	    	try { 
	    	Statement st = null ;
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
	 public boolean updateVersicherung(int id,String name ) throws SQLException {   
		  	
		  	Connection con = conn.connDb();
		  	String query= "UPDATE versich SET name=? WHERE id= ? " ; 
		  	boolean key = false; 
		  	try { 
		  	Statement st = null ;
		  	st = con.createStatement(); 
		  	preparedStatement = con.prepareStatement(query); 
		  	preparedStatement.setString(1, name);   
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
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	} 
	

}
