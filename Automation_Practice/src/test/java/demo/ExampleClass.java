package demo;

import org.testng.annotations.Test;

public class ExampleClass {

	
	public static void test()
	{
		System.out.println("test");
	}
	
	public void disp()
	{
		System.out.println("disp");
	}
	
	public void perform()
	{
		System.out.println("perform");
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
	
	@Test
	public void test3()
	{
		System.out.println("test3");
	}
	public static void main(String[] args)
	{
		System.out.println("Main Method");
		test();
		ExampleClass ec=new ExampleClass();
		
		ec.perform();
		
		ec.disp();
		
	}
}
