package com.vz.letustry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class VendorSelectionDAO {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/letustry";

	   //  Database credentials
	   static final String USER = "root";
	   //static final String PASS = "password";
	public static List getVendorMenuDetails(String date, int vendorId) {  
		   Connection conn = null;
		   Statement stmt = null;
		   List VendorSelectionList = new ArrayList();
		   System.out.println("Entering getVendorMenuDetails......");
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
		   
		      //String currDate= new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		      
		      sql ="select v.vendorid ,m.menuid ,m.itemname,m.description from menu m ,vendorselection v where v.date='"+date+"' and v.vendorid="+vendorId+"  and v.menuid = m.menuid";
System.out.println(sql);
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	  VendorSelectionBean vsDtls = new VendorSelectionBean();
		    	  int menuid = rs.getInt("menuid");
		    	  vsDtls.setMenuid(menuid);
		    	  int vId = rs.getInt("vendorId");
		    	  vsDtls.setVendorId(vId);
		    	  String itemname = rs.getString("itemname");
		    	  vsDtls.setItemname(itemname);
		    	  String desc = rs.getString("description");
		    	  vsDtls.setDescription(desc);
		    	  System.out.println(menuid +" "+itemname+" "+desc+" "+vId);
		    	  VendorSelectionList.add(vsDtls);
		    	  
		      }
		      
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      System.out.println(VendorSelectionList.toString());
		    
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
		   
	
		   return VendorSelectionList;
		  }
	public boolean addVendorSelectionDetails(int userId, String date, String itemselected) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isAdded = true;
		System.out.println("Entering addVendorSelectionDetails  "+userId +" "+date +" " +itemselected);

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			// conn = DriverManager.getConnection(DB_URL,USER,PASS);
			conn = DriverManager.getConnection(DB_URL, USER, "");
			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			String currDate = new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date());
			
			List<String> iList = Arrays.asList(itemselected.split(","));
			for(int i=0;i<iList.size();i++)
			{
			stmt = conn
					.prepareStatement("INSERT INTO vendorselection(vendorid,date ,menuid ) values (?,? ,?)");
		
			stmt.setInt(1, userId);
			stmt.setString(2, date);
					
			stmt.setString(3, iList.get(i));
			
			System.out.println("SQL " +stmt);
			stmt.executeUpdate();
			}
			//conn.commit();

		} catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("Exception " +se.getMessage());
			se.printStackTrace();
			isAdded = false;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			System.out.println("Exception " +e.getMessage());
			isAdded = false;
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception " +e.getMessage());
				e.printStackTrace();
				isAdded = false;
			}

		}// end try

		return isAdded;
	}
	
	public static void main(String args[])
	{
		VendorSelectionDAO db= new VendorSelectionDAO();
		db.getVendorMenuDetails("2015-9-29", 1);
	}


}
