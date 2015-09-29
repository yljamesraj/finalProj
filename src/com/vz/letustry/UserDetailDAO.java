package com.vz.letustry;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetailDAO {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/letustry";

	   //  Database credentials
	   static final String USER = "root";
	   //static final String PASS = "password";
	public static UserDtlsBean getUserDetails(String username, String passwd) {  
		   Connection conn = null;
		   Statement stmt = null;
		   UserDtlsBean usrDtls = new UserDtlsBean();
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      //conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      conn = DriverManager.getConnection(DB_URL,USER,"");
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM users where username='";
		      sql += username + "'" ;
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	
		    	  String name = rs.getString("username");
		    	  usrDtls.setVzid(name);
		    	  String password = rs.getString("password");
		    	  usrDtls.setPassword(password);
		    	  String role = rs.getString("role");
		    	  usrDtls.setRole(role);
		    	  
		      }
		      
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      System.out.println(usrDtls.getPassword()+" "+usrDtls.getRole()+" "+usrDtls.getVzid());
		      return usrDtls;
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		      
		   }//end try
		   System.out.println("Goodbye!");
		   return usrDtls;
		  }
	public static void main(String args[])
	{
		UserDetailDAO db= new UserDetailDAO();
		db.getUserDetails("Jsssyothi", "verizon1");
	}


}
