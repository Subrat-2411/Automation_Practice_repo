package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	WebDriver driver;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(xpath="(//input[@name='Edit'])[1]")
	private WebElement editButton;
	
	@FindBy(xpath="(//input[@name='Delete'])[1]")
	private WebElement deleteButton;
	
	@FindBy(xpath="(//input[@name='Duplicate'])[1]")
	private WebElement duplicateButton;
	
	@FindBy(xpath="//input[@title='Locate Map']")
	private WebElement locateMapButton;
	
	@FindBy(xpath="//img[@src='themes/images/btnL3Search-Faded.gif']")
	private WebElement searchIcon;
	
	@FindBy(xpath="//a[text()='Send Mail']")
	private WebElement sendMailLink;
	
	@FindBy(xpath="//a[text()='Add Event']")
	private WebElement addEventLink;
	
	@FindBy(xpath="//a[text()='Add Note']")
	private WebElement addNoteLink;
	
	@FindBy(xpath="//a[text()='Add To Do']")
	private WebElement addToDoLink;
	
	@FindBy(xpath="(//img[@title='Previous'])[1]")
	private WebElement previousIcon;
	
	@FindBy(xpath="//img[@name='jumpBtnIdTop']")
	private WebElement jumpIcon;
	
	@FindBy(xpath="//a[text()='Create Mail Merge templates ']")
	private WebElement createMailMergeTemplatesLink;
	
	@FindBy(xpath="//img[@alt='Open Calendar...']")
	private WebElement calendarIcon;
	
	@FindBy(xpath="//img[@alt='Show World Clock...']")
	private WebElement worldClockIcon;
	
	@FindBy(xpath="//img[@alt='Open Calculator...']")
	private WebElement calculatorIcon;
	
	@FindBy(xpath="//img[@alt='Last Viewed']")
	private WebElement lastViewedIcon;
	
	@FindBy(xpath="//img[@alt='Import Contacts']")
	private WebElement importContactsIcon;
	
	@FindBy(xpath="//img[@alt='Export Contacts']")
	private WebElement exportContactsIcon;
	
	@FindBy(xpath="//img[@alt='Contacts Settings']")
	private WebElement contactsSettingsIcon;
	
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHeaderText() {
		return headerText;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getDuplicateButton() {
		return duplicateButton;
	}

	public WebElement getLocateMapButton() {
		return locateMapButton;
	}

	public WebElement getSearchIcon() {
		return searchIcon;
	}

	public WebElement getSendMailLink() {
		return sendMailLink;
	}

	public WebElement getAddEventLink() {
		return addEventLink;
	}

	public WebElement getAddNoteLink() {
		return addNoteLink;
	}

	public WebElement getAddToDoLink() {
		return addToDoLink;
	}

	public WebElement getPreviousIcon() {
		return previousIcon;
	}

	public WebElement getJumpIcon() {
		return jumpIcon;
	}

	public WebElement getCreateMailMergeTemplatesLink() {
		return createMailMergeTemplatesLink;
	}

	public WebElement getCalendarIcon() {
		return calendarIcon;
	}

	public WebElement getWorldClockIcon() {
		return worldClockIcon;
	}

	public WebElement getCalculatorIcon() {
		return calculatorIcon;
	}

	public WebElement getLastViewedIcon() {
		return lastViewedIcon;
	}

	public WebElement getImportContactsIcon() {
		return importContactsIcon;
	}

	public WebElement getExportContactsIcon() {
		return exportContactsIcon;
	}

	public WebElement getContactsSettingsIcon() {
		return contactsSettingsIcon;
	}
	
	public void verifyContactName(String firstName)
	{
		
		
		if(headerText.getText().contains(firstName)) 
			System.out.println("Contact is created successfully.");
			
		else
			System.out.println("Contact is not created.");
		
	}
	
	
}
