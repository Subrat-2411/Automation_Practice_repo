package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class KSRTCAppTest {

	
	@Test
	public void popUp()
	{
		
		String sPlace="Adoni";
		
		String dPlace="Bellary"; 
		
		String month="September";
		
		String date1 = "8";
		
		String date2 = "23";
		
        ChromeOptions opt=new ChromeOptions();
		
		opt.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://ksrtc.in/");
		
		driver.findElement(By.xpath("//span[text()='Select Departure City']")).click();
		
		driver.findElement(By.xpath("//li[text()='"+sPlace+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Select Destination City']")).click();
		
		driver.findElement(By.xpath("(//ul[@class='chosen-results']/li[text()='"+dPlace+"'])[2]")).click();
		
		driver.findElement(By.xpath("//input[@id='departDate']")).click();
		
		boolean flag;
		
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//span[text()='"+month+"']/ancestor::div[contains(@class,'ui-datepicker-header')]/following-sibling::table//a[text()='"+date1+"']")).click();
				flag=true;
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
		}
		
		if(flag==false)
			System.out.println("Date Selection is not possible at the moment ! Try after some time");
		
		else {
			System.out.println("Successfully date selected.");
		
		driver.findElement(By.xpath("//label[@class='checklable']/preceding-sibling::input")).click();
		
		driver.findElement(By.xpath("//div[@id='submitSearch']")).click();
		
		driver.findElement(By.xpath("//input[@id='returnjdate']")).click();
		
		boolean flag2=false;
		for(;;) {
		try {
			driver.findElement(By.xpath("//strong[text()='"+month+" 2025']/../following-sibling::table/descendant::td[text()='"+date2+"']")).click();
			flag2=true;
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//div[contains(@aria-label,'Move forward')]")).click();
		}
		}
		
		if(flag2==false)
			System.out.println("Return Date Selection is not possible at the moment ! Try after some time");

		}
		
		driver.close();
		
		System.out.println("----------Done---------------");
	}
	
}
