package demo;

import org.testng.annotations.Test;

import com.crm.Org.OR.ContactsPage;
import com.crm.Org.OR.HomePage;
import com.crm.baseTest.BaseClass;
import com.crm.generic.WebDriverUtility.WebDriverUtility;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.fileUtility.JavaUtility;

public class CreateContactsInVTigerTest extends BaseClass {

	@Test
	public void createContactTest() throws Throwable
	{

		FileUtility futil=new FileUtility();
		
		WebDriverUtility wutil=new WebDriverUtility();
		
		JavaUtility jutil=new JavaUtility();
		
		ExcelUtility eutil=new ExcelUtility();
		
		
		int ranNum=jutil.getRandomNumber();
		
		String lastName=eutil.getDataFromExcel("Organization",1,2)+ranNum;
		
		String website=eutil.getDataFromExcel("Organization",1,3);
		
		String option=eutil.getDataFromExcel("Organization",2,4);
		
		HomePage hp=new HomePage(driver);
		
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		
		Thread.sleep(2000);
		
		cp.getCreateContactIcon().click();
		
		
//		
//		CreatingNewOrganization co=new CreatingNewOrganization(driver);
//		
//		co.createOrganization(oName, website);
//		
//		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
//		
//		oip.verifyOrganizationName(oName);
//		
//		hp.getOrganizationLink().click();
//		
//		op.searchElement(oName,option);
//		
//		driver.findElement(By.xpath("//a[text()='"+oName+"']/../../td/a[text()='del']")).click();
//		
//		wutil.switchToAlert(driver).accept();
//		
//		System.out.println("Organization is deleted successfully.");
//		
		hp.logOut();
		
		driver.close();
	
	}
}
