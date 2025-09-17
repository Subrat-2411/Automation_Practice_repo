package testNGExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.Org.OR.ContactInformationPage;
import com.crm.Org.OR.ContactsPage;
import com.crm.Org.OR.CreatingNewContactPage;
import com.crm.Org.OR.HomePage;
import com.crm.baseTest.BaseClass;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.listenerUtility.ListenerUtility;
//import com.crm.generic.listenerUtility.ListenerUtility;
import com.crm.generic.objectUtility.UtilityClassObject;

@Listeners(ListenerUtility.class)
public class CreateContactTest extends BaseClass {

	
	@Test(groups = "RegressionSuite",successPercentage = 50,invocationCount=4)
	public void createContactWithMandatoryTest() throws Throwable
	{
		UtilityClassObject.getTest().log(Status.INFO,"Read data from excel");
		
		ExcelUtility eutil=new ExcelUtility();
		
		String lastName=eutil.getDataFromExcel("Contacts",1,4);
		
		Reporter.log(lastName,true);
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to Contacts");

		HomePage hp=new HomePage(driver);
		
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO,"Click on create Contact Icon");

		cp.getCreateContactIcon().click();
		
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		
		UtilityClassObject.getTest().log(Status.INFO,"Create a contact with all mandatory details");

		ccp.createContactWithMandatoryDetails(lastName);
		
		UtilityClassObject.getTest().log(Status.INFO,"Verify the contact");

		ContactInformationPage cip=new ContactInformationPage(driver);
		
		cip.verifyContactName(lastName);
		
		
		
		
	}
	@Test(groups = {"SmokeTest"})
	public void createContactWithOrganizationTest() throws Throwable
	{
		
		String name="Tek Pyramid";
		
//	    JavaUtility jutil=new JavaUtility();
		
		ExcelUtility eutil=new ExcelUtility();
		
		String lastName=eutil.getDataFromExcel("Contacts",2,4);
		
		Reporter.log(lastName);
		
		HomePage hp=new HomePage(driver);
		
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		
		cp.getCreateContactIcon().click();
		
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		
		ccp.getLastNameTextField().sendKeys(lastName);
		
		Thread.sleep(1000);
		
		ccp.getOrganizationNameLookUpIcon().click();
		
		wutil.switchToWindowOnURL(driver,"action=Popup");
		
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(name);
		
		WebElement inDropDown = driver.findElement(By.xpath("//select[@name='search_field']"));
		
		Select sel=new Select(inDropDown);
		
		sel.selectByIndex(0);
		
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		
		wutil.switchToWindowOnURL(driver, "module=Contacts");
		
		ccp.getSaveButton().click();
				
		ContactInformationPage cip=new ContactInformationPage(driver);
		
		cip.verifyContactName(lastName);
		
		Reporter.log("Test case Passed");
		
	}
}
