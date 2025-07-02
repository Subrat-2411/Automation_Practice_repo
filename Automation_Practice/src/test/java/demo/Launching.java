package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Launching {
	
	@Test
	public void launch()
	{
		WebDriver driver=new ChromeDriver();
		driver.close();
	}
}
