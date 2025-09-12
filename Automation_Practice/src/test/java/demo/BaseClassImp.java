package demo;

import org.testng.annotations.BeforeClass;
import org.junit.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassImp {

	
	
	@BeforeSuite
	public void report()
	{
		System.out.println("report bs 2");
	}
	
	@BeforeSuite
	public void reportC()
	{
		System.out.println("report bs 1");

	}
	
	@BeforeClass
	public void beforeclass1()
	{
		System.out.println("report bc 1");
	}
	@BeforeClass
	public void beforeclass2()
	{
		System.out.println("report bc 2");
	}
	@AfterClass
	public void afterclass1()
	{
		System.out.println("report bc 2");
	}
	
	@AfterClass
	public void afterclass2()
	{
		System.out.println("report bc 2");
	}
	
	@Test
	public void test1()
	{
		System.out.println("test1");

	}
	
	@Test
	public void test2()
	{
		System.out.println("test2");

	}
	@AfterSuite
	public void reportB()
	{
		System.out.println("report as 1");

	}
	
	@AfterSuite
	public void reportBa()
	{
		System.out.println("report as 2");

	}
}
