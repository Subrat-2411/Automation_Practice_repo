package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CandyMapperApplicationTest {

	@Test
	public void handlingDropDown()	
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://candymapper.com/");
		
		driver.findElement(By.xpath("//*[local-name()='svg' and contains(@id,'close-icon')]")).click();
		

		WebElement sliderLabel = driver.findElement(By.xpath("//span[contains(text(),'Connect')]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(sliderLabel).perform();
		
		WebElement fElement = driver.findElement(By.xpath("(//iframe[contains(@id,'iframe')])[2]"));
		
		driver.switchTo().frame(fElement);
		
		WebElement countryDropDown = driver.findElement(By.xpath("//select[@id='tCounty']"));
		
		Select sel=new Select(countryDropDown);
		
		sel.selectByIndex(14);
		
		WebElement option = sel.getFirstSelectedOption();
		
		System.out.println("15th Option is "+option.getText());
		
		driver.quit();
	}
	
	
}
