package testNGExamples;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListenerImpclass.class)
public class BasicTestScript extends BaseClassImp{

	@Test
	public void test1()
	{
		System.out.println("Good Morning");
	}
	
	public void test2()
	{
		System.out.println("Good Morning");
	}
}
