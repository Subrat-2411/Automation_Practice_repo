package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class OrganizationsPage {
	
	WebDriver driver=null;

	@FindAll({@FindBy(xpath="//img[@alt='Create Organization...']"),@FindBy(xpath="//img[@title='Create Organization...']")})
	private WebElement createOrganizationIcon;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForTextField;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowButton;
	
	@FindBy(xpath="//div[@id='searchAcc']/descendant::td/div/select")
	private WebElement InDropDown;
	
	public OrganizationsPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchForTextField() {
		return searchForTextField;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public WebElement getInDropDown() {
		return InDropDown;
	}

	public void searchElement(String oName,String text)
	{	
		searchForTextField.sendKeys(oName);
		
		Select sel=new Select(InDropDown);
		
		sel.selectByValue(text);
		
		searchNowButton.click();
		
	}
	
}
