package testNGExamples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Reporter;

public class WebDriverListenerImp implements WebDriverListener{

	 public void beforeFindElement(WebDriver driver, By locator) {
		 
		 Reporter.log(locator.toString(), true);
	 }
	 
	 public void beforeSendKeys(WebElement ele,CharSequence... keysToSend) {
		 System.out.println("beforeSendkyes");
	 }
	 
	 public void beforeClick(WebElement ele) {
		 System.out.println("before click");
	 }

	@Override
	public void beforeSendKeys(Alert alert, String text) {
		
		System.out.println(text);
	}

	@Override
	public void afterClose(WebDriver driver) {
		
		System.out.println("Driver got closed .");
	}

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		
		String ts=method.getName();
		
		System.out.println(ts);
		
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		//Calendar cal=sdf.getCalendar();
	}
	
	
	
	
	
	 
	 
}
