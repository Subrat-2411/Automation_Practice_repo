package testNGExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class SmokeTest {

	@Parameters("browser")
	@Test(groups = "smoke")
	public void smokeTest(String browser)
    {
		WebDriver driver;
		String BROWSER=browser;
		if(BROWSER.equals("chrome"))
	     driver=new ChromeDriver();
		
		else if(BROWSER.equals("firefox"))
		     driver=new FirefoxDriver();
		else if(BROWSER.equals("safari"))
		     driver=new SafariDriver();
		else
		     driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		System.out.println("smokeTest is Passed.");
		
	}
	
	@Test(groups = "regression")
	public void regressionTest()
    {
		
		System.out.println("regressionTest");
		
	}
}
