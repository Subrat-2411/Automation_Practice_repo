package com.crm.contactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Org.OR.ContactInformationPage;
import com.crm.Org.OR.ContactsPage;
import com.crm.Org.OR.CreatingNewContactPage;
import com.crm.Org.OR.HomePage;
import com.crm.baseTest.BaseClass;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.listenerUtility.ListenerUtility;

@Listeners(ListenerUtility.class)
public class CreateContactTest extends BaseClass {

	
	@Test(groups = {"RegressionTest"})
	public void createContactWithMandatoryTest() throws Throwable
	{

		
		/*Read data from excel file */
		ExcelUtility eutil=new ExcelUtility();
		
		String lastName=eutil.getDataFromExcel("Contacts",1,4);
		
		/*Printing the data fetched from excel file */
		Reporter.log(lastName,true);
		
		/*Navigate to Contacts Link */
		HomePage hp=new HomePage(driver);
		
		hp.getContactsLink().click();
		
		/*Click on create Contact Icon */
		ContactsPage cp=new ContactsPage(driver);
		
		cp.getCreateContactIcon().click();
		
		/*Create a contact using all the mandatory details*/
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		
		ccp.createContactWithMandatoryDetails(lastName);
		
		/*Verify the contact which you have created */
		ContactInformationPage cip=new ContactInformationPage(driver);
		
		cip.verifyContactName(lastName);
		
		
		
		
	}
	@Test(groups = {"SmokeTest"})
	public void createContactWithOrganizationTest() throws Throwable
	{
		/*Taking an orgnaization name*/
		String name="Tek Pyramid";
		
		/*Reading data from excel */
		ExcelUtility eutil=new ExcelUtility();
		
		String lastName=eutil.getDataFromExcel("Contacts",2,4);
		/*Printing the data fetched from excel file */
		Reporter.log(lastName);
		
		HomePage hp=new HomePage(driver);
		
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		/*Click on create Contact Icon */
		cp.getCreateContactIcon().click();
		
		/*Sending data to the lastNameTextField */
		CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
		
		ccp.getLastNameTextField().sendKeys(lastName);
		
		/*Click on create Contact Icon */
		ccp.getOrganizationNameLookUpIcon().click();
		
		/*Switching the control to the organization window */
		wutil.switchToWindowOnURL(driver,"action=Popup");
		
		/*Sending data to the searchTextField */
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(name);
		
		/*Selecting an option from InDropDown */
		WebElement inDropDown = driver.findElement(By.xpath("//select[@name='search_field']"));
		
		Select sel=new Select(inDropDown);
		
		sel.selectByIndex(0);
		
		/*Searching the element and perform click operation */
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		
		/*Switch back to the page */
		wutil.switchToWindowOnURL(driver, "module=Contacts");
		
		/*click on save button */
		ccp.getSaveButton().click();
				
		/*Verify the contact which you have created */
		ContactInformationPage cip=new ContactInformationPage(driver);
		
		cip.verifyContactName(lastName);
		
		/*providing a log message*/
		Reporter.log("Test case Passed",true);
		
	}
}
