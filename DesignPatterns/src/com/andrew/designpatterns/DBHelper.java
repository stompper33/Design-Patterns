package com.andrew.designpatterns;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author andrewcalderon
 *  @Returns a database connection for a specified data source
 *          a Factory method that returns a connection object
 */
public class DBHelper {

	public static Connection getConnection(final String username, final String password, final String connectionString )
	{
		System.out.println("DBHelper: ------- Checking for Driver for JDBC Connection ----");
		
		
		//check for driver
		try{
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("DBHelper: --- JDBC Driver Missing From Classpath!");
			e.printStackTrace();
		}
		
		System.out.println("DBHelper: ------- Driver for JDBC Connection Registered SUCCESSFULLY! ----");
		
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection(connectionString,username,password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT VERSION()");
			
			if(rs.next())
			{
				System.out.println("DBHelper: ------- Database Version is " + rs.getString(1));
			}
		} catch(SQLException e){
			System.out.println("DBHelper: ------- Connection FAILED!");
			e.printStackTrace();
		}
		
		if(conn != null){
			System.out.println("DBHelper: ------- SUCCESSFULLY Made Database Connection!");
		}
		else{
			System.out.println("DBHelper: ------- FAILED to Make Database Connection");
		}
		
		return conn;
	}
	
	public static void killConnection(Connection conn)
	{
		if(conn != null)
		{
			try {
				conn.close();
				System.out.println("DBHelper: ------- Connection CLOSED!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		String username = "postgres";
		String password = "super";
		String url = "jdbc:postgresql://localhost:5432/hibernatedb";
		              
		
		Connection conn = DBHelper.getConnection(username, password, url);
		
		DBHelper.killConnection(conn);
		
	}
}
