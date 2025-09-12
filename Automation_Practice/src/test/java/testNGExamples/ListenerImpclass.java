package testNGExamples;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpclass implements ITestListener,ISuiteListener{

	@Override
	public  void onStart(ISuite suite) {
		
		System.out.println("Running onStart of ISuiteListener");

		
		System.out.println(suite.getName());
		
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Running onFinish of ISuiteListener");

		System.out.println(suite.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Running onTestStart of ITestListener");

		System.out.println(result.getTestName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Running onTestSuccess of ITestListener");

		System.out.println(result.getTestName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
		
//		System.out.println(result.getThrowable());

		System.out.println("Running onTestFailure of ITestListener");

       System.out.println(result.getTestName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Running onTestSkipped of ITestListener");
		System.out.println(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getThrowable());
		System.out.println("Running onTestFailedButWithinSuccessPercentage of ITestListener");
//		System.out.println(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Running onTestFailedWithTimeout of ITestListener");
		System.out.println(result.isSuccess());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Running onStart of ITestListener");
		System.out.println(context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Running onFinish of ITestListener");
		System.out.println(context.getName());
		
		
	}
	
	/*public interface ITestNGListener {

		  @return - <code>true</code> if the current listener can be considered for execution. 
		  
		  default boolean isEnabled() {
		    return true;
		  }
		}*/
	

	
	
}
