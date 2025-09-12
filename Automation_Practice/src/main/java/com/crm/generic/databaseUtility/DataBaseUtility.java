package com.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * @author Subrat Kumar Sahoo
 * This class contains all database reusable methods like getDBConnection(),executeSelectQuery() etc.
 */
public class DataBaseUtility {

	Connection con=null;
	
	/**
	 * This method is used to build the connection with Database.
	 * @param url
	 * @param username
	 * @param password
	 * @throws SQLException
	 */
	public void getDBConnection(String url,String username,String password) throws SQLException
	{
		try {
			Driver driver=new Driver();
			
			DriverManager.registerDriver(driver);
			
			con=DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
		System.out.println("Connection is yet to be established.");
		}
		
	}
	
	/**
	 * This method is used to connect to the database.
	 * @throws SQLException
	 */
	
	public void getDBConnection() throws SQLException
	{
		try {
			Driver driver=new Driver();
			
			DriverManager.registerDriver(driver);
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/d1","root","root");
			
		} catch (SQLException e) {
		System.out.println("Connection is yet to be established.");
		}
		
	}
	
	/**
	 * This method is used to close the database connection.
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException
	{
		con.close();
		
	}
	
	
	/**
	 * This  method is used to execute only select query and return the result in ResultSet. 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeSelectQuery(String query) throws SQLException {
		
		ResultSet res=null;
		
		try {
			Statement st=con.createStatement();
			
			res=st.executeQuery(query);
		} catch (SQLException e) {
			
			System.out.println("Select Query is not executed.");
		}
		
		return res;
		
	}
	
	
	/**
	 * This method is used to execute only non-select query and returns the result in int.
	 * @param query
	 * @return
	 */
	public int executeNonSelectQuery(String query)
	{
		
		int res=0;
		
		try {
			Statement st=con.createStatement();
			
			res=st.executeUpdate(query);
		} catch (SQLException e) {
			
			System.out.println("Select Query is not executed.");
		}
		
		return res;
		
	}
	
	
	/**
	 * This method is used to execute either select or non-select query and returns the result in boolean. 
	 * @param query
	 * @return
	 */
	public boolean executeAnyQuery(String query)
	{
		
		boolean res = false;
		
		try {
			Statement st=con.createStatement();
			
			res=st.execute(query);
		} catch (SQLException e) {
			
			System.out.println("Select Query is not executed.");
		}
		
		return res;
		
	}
	
	
}
