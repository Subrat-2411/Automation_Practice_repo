package testNGExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class RegressionTest {
	
	@Parameters("browser")
	@Test(groups = "regression")
	public void regressionTest(String browser)
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
		
		driver.get("https://demowebshop.tricentis.com/");
		
		System.out.println("regressionTest");
		
	}
	
	@Test(groups = "smoke")
	public void smokeTest()
    {
		
		System.out.println("smokeTest");
		
	}
}
