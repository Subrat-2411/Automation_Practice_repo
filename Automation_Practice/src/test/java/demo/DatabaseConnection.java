package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DatabaseConnection {

	@Test
	public void fetchDatas() throws SQLException
	{
		Connection conn=null;
		try {
		Driver driver=new Driver();   // creating database driver
		
		DriverManager.registerDriver(driver);  // load/register database driver
		
		conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root"); // connect to database
		
		Statement st = conn.createStatement();  // create sql statements
		
		System.out.println("--------------------Done----------------");
		
		ResultSet res = st.executeQuery("select * from john");
		
//		String data = res.getString(0);
		
		while(res.next()) {
		String data=res.getString(1);
		System.out.println(data);
		}
		}
//		catch(Exception e)
//		{
//			
//		}
//		
		finally {
		conn.close();
		}
		
		
	}
}
