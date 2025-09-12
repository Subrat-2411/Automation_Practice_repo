package demo;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.Org.OR.CreatingNewOrganization;
import com.crm.Org.OR.HomePage;
import com.crm.Org.OR.OrganizationInformationPage;
import com.crm.Org.OR.OrganizationsPage;
import com.crm.baseTest.BaseClass;
import com.crm.generic.WebDriverUtility.WebDriverUtility;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.JavaUtility;

public class VtigerAutomationAppUsingPropertiesTest extends BaseClass{

	@Test
	public void createOrganization() throws IOException, ParseException, InterruptedException
	{
//		FileUtility futil=new FileUtility();
		
		WebDriverUtility wutil=new WebDriverUtility();
		
		JavaUtility jutil=new JavaUtility();
		
		ExcelUtility eutil=new ExcelUtility();
		
		int ranNum=jutil.getRandomNumber();
		
		String oName=eutil.getDataFromExcel("Organization",1,2)+ranNum;
		
		String website=eutil.getDataFromExcel("Organization",1,3);
		
		String option=eutil.getDataFromExcel("Organization",2,4);
		
		HomePage hp=new HomePage(driver);
		
		hp.getOrganizationLink().click();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		
		op.getCreateOrganizationIcon().click();
		
		CreatingNewOrganization co=new CreatingNewOrganization(driver);
		
		co.createOrganization(oName, website);
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		
		Thread.sleep(2000);
		
		oip.verifyOrganizationName(oName);
		
		hp.getOrganizationLink().click();
		
		op.searchElement(oName,option);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='"+oName+"']/../../td/a[text()='del']")).click();
		
		wutil.switchToAlert(driver).accept();
		
		System.out.println("Organization is deleted successfully.");
		
//		Thread.sleep(2000);
	}
}
