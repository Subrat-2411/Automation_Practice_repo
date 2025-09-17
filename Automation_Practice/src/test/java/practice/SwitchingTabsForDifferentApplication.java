package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingTabsForDifferentApplication {

	@Test
	public void switchingTabsForDiffApp()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
		
		String dwsHandleId = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);// Switching 
		
		driver.get("https://www.flipkart.com/");
		
		String flipkartHandleId = driver.getWindowHandle();
		
		driver.switchTo().window(dwsHandleId);
		
		driver.quit();
	}
}
