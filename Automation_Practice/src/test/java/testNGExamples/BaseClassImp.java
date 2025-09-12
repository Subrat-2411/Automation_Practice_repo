package testNGExamples;

import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClassImp {

	@BeforeSuite
	public void beforeS()
	{
		System.out.println("@BeforeSuite");
	}
	
	@BeforeTest
	public void beforeT()
	{
		System.out.println("@BeforeTest");
	}
	
	@BeforeClass
	public void beforeC()
	{
		System.out.println("@BeforeClass");
	}
	
	@BeforeMethod
	public void beforeM()
	{
		System.out.println("BeforeSuite");
	}
	@AfterMethod
	public void afterM()
	{
		System.out.println("@AfterMethod");
	}
	
	@AfterClass
	public void afterC()
	{
		System.out.println("@AfterClass");
	}
	
	@AfterTest
	public void afterT()
	{
		System.out.println("@AfterTest");
	}
	@AfterSuite
	public void afterS()
	{
		System.out.println("@AfterSuite");
	}
}
