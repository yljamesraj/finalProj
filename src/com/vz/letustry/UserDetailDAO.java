package com.vz.letustry;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDetailDAO {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   //static final String DB_URL = "jdbc:mysql://localhost";
	   static final String DB_URL = "jdbc:mysql://us-cdbr-iron-east-03.cleardb.net/ad_e0a63817d8663c4";

	   //  Database credentials
	  // static final String USER = "root";
	   static final String USER = "ba55310962c331";
	   
	   //static final String PASS = "password";
	   static final String PASS = "217e6372";
	   
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
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...password is +" + PASS);
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
		    	  int userId = rs.getInt("userid");
		    	  usrDtls.setUserid(Integer.toString(userId));
		    	  
		      }
		      
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      System.out.println(usrDtls.getPassword()+" "+usrDtls.getRole()+" "+usrDtls.getVzid() + " "+ usrDtls.getUserid());
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
	
	public static  boolean insertSQLs() {  
		   Connection conn = null;
		   Statement stmt = null;
		   //UserDtlsBean usrDtls = new UserDtlsBean();
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database1111133434...");
		      //conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...password is fsgr111 +" + PASS);
		      stmt = conn.createStatement();
		         
		      
		      String   sql = "CREATE TABLE users (userid INT NOT NULL AUTO_INCREMENT, username VARCHAR(20) NOT NULL, password VARCHAR(20) NOT NULL, role VARCHAR(20), primary key(userid))";
		       stmt.addBatch(sql);
		       sql = "CREATE TABLE vendor(vendorid INT NOT NULL AUTO_INCREMENT, vendorname VARCHAR(50) NOT NULL, contactno VARCHAR(20) NOT NULL, location VARCHAR(20), primary key(vendorid))";
		       stmt.addBatch(sql);
		       sql = "CREATE TABLE menu(menuid INT NOT NULL AUTO_INCREMENT, itemname VARCHAR(50) NOT NULL, description VARCHAR(100), status VARCHAR(10), start_date DATE,end_date DATE,primary key  (menuid))";
		       stmt.addBatch(sql);
		       sql = "CREATE TABLE vendorselection(vendorid INT, date DATE,menuid INT,  FOREIGN KEY (vendorid)  REFERENCES vendor(vendorid),FOREIGN KEY (menuid)  REFERENCES menu (menuid))";
		       stmt.addBatch(sql);
		       sql = "CREATE TABLE empselection(empid VARCHAR(20), date DATE,menuid INT,  rating INT, comments VARCHAR(200), FOREIGN KEY (menuid)  REFERENCES menu(menuid))";
		       stmt.addBatch(sql);
		       

		       sql= "insert into vendor(vendorname , contactno, location) values('Saravana' ,9084976733,'RMZ')";
		       stmt.addBatch(sql);
		       sql= "insert into vendor(vendorname , contactno, location) values('Kannan' ,9084976733,'RMZ')";
		       stmt.addBatch(sql);

		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Pizza','one small size pizza' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Sandwich','2 cheese sandwich' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('French fries','cripsy french fries' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Choco lava cake','filled with choco' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Pongal','20gm of pongal' , '2','2015-9-19','2015-9-19')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Burger','veg burger filled with panner patty' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Dosai','2 Dosai' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Samosa','4 small size samosa' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Sprouts','20 gms of sprouts' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Butter Corn','30 gms' , '2','2015-9-19','2015-9-19')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Bonda','20 gms of sprouts' , '2','2015-9-29','2015-9-29')";
		       stmt.addBatch(sql);
		       sql= "insert into menu (itemname ,description ,status,start_date,end_date )values ('Vadai','30 gms' , '2','2015-9-19','2015-9-19')";
		       stmt.addBatch(sql);


		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (4,'2015-9-29' ,9,1,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (5,'2015-9-29' ,9,2,'Bad')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (6,'2015-9-29' ,9,3,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (7,'2015-9-29' ,9,2,'Worst')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (8,'2015-9-29' ,9,3,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (9,'2015-9-29' ,9,1,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (10,'2015-9-29' ,9,2,'Good')";
		       stmt.addBatch(sql);


		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (11,'2015-9-29' ,9,1,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (12,'2015-9-29' ,9,2,'Bad')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (13,'2015-9-29' ,9,3,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (14,'2015-9-29' ,9,2,'Worst')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (15,'2015-9-29' ,9,3,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (16,'2015-9-29' ,10,1,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (17,'2015-9-29' ,10,2,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (18,'2015-9-29' ,10,1,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (19,'2015-9-29' ,10,2,'Bad')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (20,'2015-9-29' ,10,3,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (21,'2015-9-29' ,6,2,'Worst')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (22,'2015-9-29' ,5,3,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (23,'2015-9-29' ,6,1,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (24,'2015-9-29' ,6,2,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (25,'2015-9-29' ,7,2,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (26,'2015-9-29' ,9,2,'Good')";
		       stmt.addBatch(sql);
		       sql= "insert into empselection(empid,date ,menuid,rating ,comments ) values (27,'2015-9-29' ,8,2,'Good')";
		       stmt.addBatch(sql);

		       
		       
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-9-29' ,9)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-9-29' ,1)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-9-29' ,2)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-9-29' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-9-29' ,4)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-9-29' ,5)";
		       stmt.addBatch(sql);

		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-9-30' ,6)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-9-30' ,7)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-9-30' ,8)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-9-30' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-9-30' ,5)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-9-30' ,9)";
		       stmt.addBatch(sql);

		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-1' ,9)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-1' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-1' ,4)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-1' ,1)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-1' ,2)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-1' ,5)";
		       stmt.addBatch(sql);

		       

		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-3',9)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-3' ,1)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-3' ,2)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-3' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-3' ,4)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-3' ,5)";
		       stmt.addBatch(sql);


		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-4',6)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-4' ,7)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-4' ,8)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-4' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-4' ,5)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-4' ,9)";
		       stmt.addBatch(sql);


		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-5',9)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-5' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-5' ,4)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-5' ,1)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-5' ,2)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-5' ,5)";
		       stmt.addBatch(sql);


		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-6',6)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-6' ,7)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-6' ,8)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-6' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-6' ,5)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-6' ,9)";
		       stmt.addBatch(sql);


		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-7',9)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-7' ,1)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (1,'2015-10-7' ,2)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-7' ,3)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-7' ,4)";
		       stmt.addBatch(sql);
		       sql= "insert into vendorselection (vendorid, date ,menuid ) values (2,'2015-10-7' ,5)";
		       stmt.addBatch(sql);

		       
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'James', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Jyothi', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Jeeva', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Kavitha', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Joe', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Vicky', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'John', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Clament', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Jayanthi', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Krishna', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Juvi', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Ilaqya', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Balaji', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Sanjay', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Meena', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Poorni', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Dharani', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Preethi', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Suvi', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Lakshmi', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Sekhar', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Chandra', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Harika', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Sumathi', '123','emp')";
		       stmt.addBatch(sql);
		       sql= "insert into users ( username, password, role) values ( 'Admin', 'admin','adm')";
		       stmt.addBatch(sql);
		       
	      
		       int[] count = stmt.executeBatch();
		          
		      conn.commit();
		           
		      
		      
		      
		      
		    
		      	      
		      //int numRowsChanged = stmt.executeUpdate(sql);
		      System.out.println("Successfully ran the sqls"); 
		      //STEP 5: Extract data from result set
		     /* while(rs.next()){
		         //Retrieve by column name
		    	
		    	//  String name = rs.getString("username");
		    	  //usrDtls.setVzid(name);
		    	  //String password = rs.getString("password");
		    	  //usrDtls.setPassword(password);
		    	  //String role = rs.getString("role");
		    	  //usrDtls.setRole(role);
		    	  //int userId = rs.getInt("userid");
		    	  //usrDtls.setUserid(Integer.toString(userId));
		    	System.out.println("Successfully ran the sqls");  
		      }*/
		      
		      
		      //STEP 6: Clean-up environment
		      //rs.close();
		      stmt.close();
		      conn.close();
		      //System.out.println(usrDtls.getPassword()+" "+usrDtls.getRole()+" "+usrDtls.getVzid() + " "+ usrDtls.getUserid());
		    return true;
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
		   return true;
   }
	public static void main(String args[])
	{
		UserDetailDAO db= new UserDetailDAO();
		//db.getUserDetails("Jyothi", "verizon1");
	}


}
