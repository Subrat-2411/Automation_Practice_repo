package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.crm.generic.WebDriverUtility.WebDriverUtility;

public class OrganizationInformationPage {
	
	WebDriverUtility wutil=new WebDriverUtility();
	
	public WebDriver driver;

	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement deleteButton;
	
	public OrganizationInformationPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderText() {
		return headerText;
	}
	
	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void verifyOrganizationName(String orgName)
	{
		
		Assert.assertTrue(headerText.getText().contains(orgName), "Organization is not created.");
		
		Reporter.log("Organization is created successfully.");
		
		
	}
	
	public void verifyOrganizationNameAndDelete(String orgName)
	{
		
		Assert.assertTrue(headerText.getText().contains(orgName), "Organization is not created.");
		
		Reporter.log("Organization is created successfully.",true);
		
		deleteButton.click();
		
		wutil.switchToAlert(driver).accept();
		
		Reporter.log("Organization is deleted successfully.", true);
		
		
	}
	
	
}
