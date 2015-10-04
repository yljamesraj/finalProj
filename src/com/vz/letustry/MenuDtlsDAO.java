package com.vz.letustry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuDtlsDAO {
	// JDBC driver name and database URL
   
	   
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   //static final String DB_URL = "jdbc:mysql://localhost";
	   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_e0a63817d8663c4";

	   //  Database credentials
	  // static final String USER = "root";
	   static final String USER = "ba55310962c331";
	   
	   //static final String PASS = "password";
	   static final String PASS = "217e6372";
	   
	   
	   
	public  List getAllMenuDetails() {  
		   Connection conn = null;
		   Statement stmt = null;
		   List menuDtlsList = new ArrayList();
		  
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      //conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      
		      
		     
		      
		      sql = "SELECT menuid,itemname,description FROM menu ";
		     
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	  MenuDtlsBean menuDtls = new MenuDtlsBean();
		    	  String menuid = rs.getString("menuid");
		    	  menuDtls.setMenuid(Integer.parseInt(menuid));
		    	  String itemname = rs.getString("itemname");
		    	  menuDtls.setItemname(itemname);
		    	  String description = rs.getString("description");
		    	  menuDtls.setDescription(description);
		    	  menuDtlsList.add(menuDtls);
		    	  
		      }
		      
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      System.out.println(menuDtlsList.toString() );
		   
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
		   return menuDtlsList;
		  }
	public static void main(String args[])
	{
		MenuDtlsDAO db= new MenuDtlsDAO();
		db.getAllMenuDetails();
	}


}
