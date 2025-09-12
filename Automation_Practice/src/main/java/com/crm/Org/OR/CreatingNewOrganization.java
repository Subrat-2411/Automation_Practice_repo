package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganization {

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameTextField;
	
	@FindBy(xpath="//input[@name='website']")
	private WebElement WebsiteNameTextField;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typeDropDown;
	
//	@FindBy(name="industry")
//	private WebElement ;
	
	@FindBy(xpath="(//input[contains(@value,'Save')])[1]")
	private WebElement saveButton;
	
	public CreatingNewOrganization(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
		
	}
	
	public WebElement getWebsiteNameTextField() {
		return WebsiteNameTextField;
	}

	public void createOrganization(String organizationName,String websiteName)
	{
		organizationNameTextField.sendKeys(organizationName);
		
		WebsiteNameTextField.sendKeys(websiteName);
		
		saveButton.click();
		
	}
	
	public void createOrganizationWithIndustry(String organizationName,String websiteName,String industryName)
	{
		organizationNameTextField.sendKeys(organizationName);
		
		WebsiteNameTextField.sendKeys(websiteName);
		
		Select sel=new Select(industryDropDown);
		
		sel.selectByVisibleText(industryName);
		
		saveButton.click();
		
	}
	
}
