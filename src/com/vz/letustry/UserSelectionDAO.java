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
import java.util.List;

public class UserSelectionDAO {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/letustry";

	// Database credentials
	static final String USER = "root";

	// static final String PASS = "password";
	public boolean addUserSelectionDetails(int userId, int menuId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean isAdded = true;
		System.out.println("Entering addUserSelectionDetails  "+userId +" "+menuId);

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
			stmt = conn
					.prepareStatement("INSERT INTO letustry.empselection(empid,date ,menuid,rating ,comments ) values (?,? ,?,?,?)");
			stmt.setInt(1, userId);
			stmt.setString(2, currDate);
			stmt.setInt(3, menuId);
			stmt.setInt(4, 5);
			stmt.setString(5, "");
			System.out.println("SQL " +stmt);
			stmt.executeUpdate();
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

	public static void main(String args[]) {
		UserSelectionDAO db = new UserSelectionDAO();
		db.addUserSelectionDetails(1,1);
	}

}
