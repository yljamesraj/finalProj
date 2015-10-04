package com.vz.letustry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportDAO {
	
	// JDBC driver name and database URL
		//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		//static final String DB_URL = "jdbc:mysql://localhost/letustry";

		// Database credentials
		//static final String USER = "root";
		
		   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   //static final String DB_URL = "jdbc:mysql://localhost";
		   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_e0a63817d8663c4";

		   //  Database credentials
		  // static final String USER = "root";
		   static final String USER = "ba55310962c331";
		   
		   //static final String PASS = "password";
		   static final String PASS = "217e6372";
		   

		// static final String PASS = "password";
		public HashMap<String,Integer> getCount(String  date, int vendorId) {
			VendorSelectionDAO vsobj= new VendorSelectionDAO();
			
			List vl=vsobj.getVendorMenuDetails(date,vendorId);
			
			 
			
			Connection conn = null;
			Statement stmt = null;
			boolean isAdded = true;
			
			HashMap<String,Integer> countList = new HashMap<String,Integer>();
			
			System.out.println("Entering getCount  "+date +" "+vendorId);
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
		      
				
		  	for (int i = 0; i < vl.size(); i++) {
		  		
		  		
		  		
		  		
		  			VendorSelectionBean vsb = new VendorSelectionBean();
		  			vsb = (VendorSelectionBean) vl.get(i);
		  			
		  			System.out.println(vsb.getMenuid());
		  			System.out.println(vsb.getItemname());
		  			System.out.println(vsb.getDescription());
		  		
		  	
		      
		      
		      sql = "SELECT count(*) from empselection where menuid="+vsb.getMenuid()+" and date='"+ date+"'";
		     System.out.println("SQL :"+sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	
		    	  Integer count = rs.getInt(1);
		    	  countList.put(vsb.getItemname(),count );
		    	 
		    	  
		      }
		     
		      rs.close();
		  	}
		      System.out.println(countList.toString());
		      
		      //STEP 6: Clean-up environment
		   
		      stmt.close();
		      conn.close();
		      return countList;
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
		   return countList;
		  }
		
		
		
		public static List<Object> getKeysFromValue(Map<?, ?> hm, Object value){
		    List <Object>list = new ArrayList<Object>();
		    for(Object o:hm.keySet()){
		        if(hm.get(o).equals(value)) {
		            list.add(o);
		        }
		    }
		    return list;
		  }

	public static void main(String args[])
	{
		ReportDAO db= new ReportDAO();
		db.getCount("2015-09-29", 1);
	}

}
