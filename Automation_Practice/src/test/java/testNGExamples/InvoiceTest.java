package testNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * If this test case is getting failed, it will retry the test case based on the specified limit.
 * 
 * If this test case is passed, it will not be executed again.
 */
public class InvoiceTest {

	@Test(retryAnalyzer = testNGExamples.RetryAnalyser.class)
	public void activateSim()
	{
		Assert.assertEquals("Login", "Home");
		System.out.println("Sim activated.");
	}
}
