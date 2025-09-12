package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CliniqueApplicationTest {

	@Test
	public void mouseHover() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.clinique.in/");
		
		WebElement skincareLink = driver.findElement(By.xpath("(//a[contains(text(),'Skincare')])[2]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(skincareLink).perform();
		
		Thread.sleep(5000);
		
//		try
//		{
//			driver.findElement(By.xpath("(//button[contains(@class,'close-btn')])[1]")).click();
//		}
//		catch(Exception e)
//		{
//			System.out.println("Cookies handled successfully.");
//		}
		
		List<WebElement> productLists = driver.findElements(By.xpath("//a[contains(text(),'All Skincare')]/following-sibling::a"));
		
		System.out.println("List of all "+productLists.size()+" products :-");
		
		System.out.println("-------------------------");
		
//		System.out.println();
		
		for(int i=0;i<=productLists.size()-1;i++)
		{
			String pName = productLists.get(i).getText();
			
			System.out.println((i+1)+". "+pName);
		}
		
		
		@SuppressWarnings("unused")
		WebElement signInLink = driver.findElement(By.xpath("(//span[contains(text(),'In')])[1]"));
		
		driver.quit();
		System.out.println();
	}
}
