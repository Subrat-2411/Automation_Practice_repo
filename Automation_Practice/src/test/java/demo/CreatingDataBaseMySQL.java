package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class CreatingDataBaseMySQL {

	@Test
	public void databaseCreation() throws SQLException
	{
		Driver driver=new Driver();// Creating a database driver
		
		DriverManager.registerDriver(driver);// load/register the driver.........
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "root");// Creating a connection
		
		Statement st = con.createStatement();// Create Sql statements ..............................

		
		// creating a database
		try {
	        st.execute("create database d2;");
	    
		} catch (SQLException e) {
			System.out.println("Handling...");
				System.out.println("Database is not created.");
		}
		
		//Using the database
		try {
			st.execute("use d2;");
		} catch (Exception e) {
				System.out.println("Using Database Query is not executed.");
		}
		
		
		// Creating the table 
		try {
			st.execute("create table Employee_Tek(name varchar(20) unique, sal numeric(4) not null);");
		}
		catch(Exception e)
		{
			System.out.println("Table is not created.");
		}
		
		
		// Altering the table by adding a column
		try {
			st.execute("alter table Employee_Tek add column age int not null;");
		} catch (Exception e) {
				System.out.println("Alter Query is not executed.");
		}
		
		
		//Inserting values into the table
		
		try {
			st.execute("insert into Employee_Tek values('Rashmi12',1000,21);");
		} catch (Exception e) {
				System.out.println("Insert Query is not executed.");
		}
		
		// Updating the values in a column
		try {
			st.execute("update Employee_Tek set name='subrat' where name='Rashmi12';");
		} catch (Exception e) {
				System.out.println("Update Query is not executed.");
		}
		
		
		// delete all the records from the database
//		try {
//			st.execute("delete from Employee_Tek;");
//		} catch (Exception e) {
//
//				System.out.println("Delete query is not created.");
//		}
		
		
		// Closing the database connection
		finally
		{
			con.close();
		}
		
	}
}
