package com.crm.baseTest;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.Org.OR.HomePage;
import com.crm.Org.OR.LoginPage;
import com.crm.generic.WebDriverUtility.WebDriverUtility;
import com.crm.generic.databaseUtility.DataBaseUtility;
import com.crm.generic.fileUtility.FileUtility;

public class BaseClass {

	public FileUtility futil=new FileUtility();
	
	public WebDriverUtility wutil=new WebDriverUtility();
	
	public DataBaseUtility dutil=new DataBaseUtility();
	
	
	public WebDriver driver=null;
	
	public static WebDriver sdriver=null;
	
//	public static WebDriver sdriver=null;
	
	@BeforeSuite(groups = {"RegressionTest","SmokeTest"})
	public void reportConfiguration() throws SQLException
	{
		System.out.println("report Configuration");
		dutil.getDBConnection();
		
		
	}
	@Parameters("browser")
	@BeforeClass(groups = {"RegressionTest","SmokeTest"})
	public void openBrowser(@Optional("chrome") String browser) throws IOException
	{
//		String browser = futil.getDataFromPropertyFile("browser");
		
		String browSer=browser;
		

		if(browSer.equals("chrome"))
			driver=new ChromeDriver();
		
		else if(browSer.equals("firefox"))
			driver=new FirefoxDriver();
		
		else if(browSer.equals("edge"))
			driver=new EdgeDriver();
		
		else if(browSer.equals("safari"))
			driver=new SafariDriver();
		
		else
			driver=new ChromeDriver();
		
		sdriver=driver;
		
//		wutil.maximizeWindow(driver);
		System.out.println("------------");

		
		wutil.implicitWait(driver);
			
		driver.get(futil.getDataFromPropertyFile("url"));
		
	}
	
	@BeforeMethod(groups = {"RegressionTest","SmokeTest"})
	public void login() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.login(futil.getDataFromPropertyFile("username"), futil.getDataFromPropertyFile("password"));
	}
	
	@AfterMethod(groups = {"RegressionTest","SmokeTest"})
	public void logOut() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		
		wutil.mouseHover(driver,hp.getAdministratorIcon());
		
		hp.getLogOutLink().click();
		
	}
	
	@AfterClass(groups = {"RegressionTest","SmokeTest"})
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite(groups = {"RegressionTest","SmokeTest"})
	public void reportBackUp() throws SQLException
	{
		System.out.println("report backup is done");
		dutil.closeConnection();
	}
}
