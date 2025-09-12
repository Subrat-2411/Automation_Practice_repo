package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactIcon;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForTextField;
	
	
	@FindBy(xpath="//div[@id='searchAcc']/descendant::select")
	private WebElement inDropDown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowButton;
	
	@FindBy(xpath="//img[@alt='Search in Contacts...']")
	private WebElement searchInContactsIcon;
	
	@FindBy(xpath="//img[@alt='Last Viewed']")
	private WebElement lastViewedIcon;
	
	public ContactsPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}

	public WebElement getSearchForTextField() {
		return searchForTextField;
	}

	public WebElement getInDropDown() {
		return inDropDown;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

	public WebElement getSearchInContactsIcon() {
		return searchInContactsIcon;
	}

	public WebElement getLastViewedIcon() {
		return lastViewedIcon;
	}
	
	
	
	
}
