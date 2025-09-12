package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewContactPage {
	
	WebDriver driver;

	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement salutationTypeDropDown;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='account_id']/../img")
	private WebElement organizationNameLookUpIcon;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadSourceDropDown;
	
	@FindBy(id="title")
	private WebElement titleTextField;
	
	@FindBy(id="email")
	private WebElement emailTextField;
	
	@FindBy(name="department")
	private WebElement departmentTextField;
	
	@FindBy(name="assistantphone")
	private WebElement assistantPhoneNoTextField;
	
	@FindBy(name="emailoptout")
	private WebElement emailOptOutCheckBox;
	
	@FindBy(name="reference")
	private WebElement referenceCheckBox;
	
	@FindBy(name="notify_owner")
	private WebElement notifyOwnerCheckBox;
	
	@FindBy(id="contact_no")
	private WebElement contactIdTextField;
	
	@FindBy(id="phone")
	private WebElement officePhoneTextField;
	
	@FindBy(id="mobile")
	private WebElement mobileTextField;
	
	@FindBy(id="homephone")
	private WebElement homePhoneTextField;
	
	@FindBy(id="otherphone")
	private WebElement otherPhoneTextField;
	
	@FindBy(id="fax")
	private WebElement faxTextField;
	
	@FindBy(name="birthday")
	private WebElement birthdayTextField;
	
	@FindBy(xpath="//input[@name='birthday']/../img")
	private WebElement birthdateCalendarIcon;
	
	@FindBy(xpath="//input[@name='contact_id']/../img")
	private WebElement reportsToLookUpIcon;
	
	@FindBy(id="secondaryemail")
	private WebElement secondaryEmailTextField;
	
	@FindBy(name="donotcall")
	private WebElement doNotCallCheckBox;
	
	@FindBy(name="button")
	private WebElement saveButton;
	
	public CreatingNewContactPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);

	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSalutationTypeDropDown() {
		return salutationTypeDropDown;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getOrganizationNameLookUpIcon() {
		return organizationNameLookUpIcon;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getTitleTextField() {
		return titleTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getDepartmentTextField() {
		return departmentTextField;
	}

	public WebElement getAssistantPhoneNoTextField() {
		return assistantPhoneNoTextField;
	}

	public WebElement getEmailOptOutCheckBox() {
		return emailOptOutCheckBox;
	}

	public WebElement getReferenceCheckBox() {
		return referenceCheckBox;
	}

	public WebElement getNotifyOwnerCheckBox() {
		return notifyOwnerCheckBox;
	}

	public WebElement getContactIdTextField() {
		return contactIdTextField;
	}

	public WebElement getOfficePhoneTextField() {
		return officePhoneTextField;
	}

	public WebElement getMobileTextField() {
		return mobileTextField;
	}

	public WebElement getHomePhoneTextField() {
		return homePhoneTextField;
	}

	public WebElement getOtherPhoneTextField() {
		return otherPhoneTextField;
	}

	public WebElement getFaxTextField() {
		return faxTextField;
	}

	public WebElement getBirthdayTextField() {
		return birthdayTextField;
	}

	public WebElement getBirthdateCalendarIcon() {
		return birthdateCalendarIcon;
	}

	public WebElement getReportsToLookUpIcon() {
		return reportsToLookUpIcon;
	}

	public WebElement getSecondaryEmailTextField() {
		return secondaryEmailTextField;
	}

	public WebElement getDoNotCallCheckBox() {
		return doNotCallCheckBox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	/**
	 * This method is used to create contact with basic details like salutation type, first name, last name, lead source, title etc.
	 * @param salutationType
	 * @param firstName
	 * @param lastName
	 * @param leadSource
	 * @param title
	 */
	public void createContactWithBasicDetails(String salutationType,String firstName,String lastName,String leadSource,String title)
	{
		
		Select sal=new Select(salutationTypeDropDown);
		
		sal.selectByContainsVisibleText(salutationType);
		
		firstNameTextField.sendKeys(firstName);
		
		lastNameTextField.sendKeys(lastName);
		
		Select lead=new Select(leadSourceDropDown);
		
		lead.selectByContainsVisibleText(leadSource);
		
		saveButton.click();
	}
	
	/**
	 * This method is used to create contact only with mandatory details like lastname.
	 * @param lastName
	 */
	public void createContactWithMandatoryDetails(String lastName)
	{
		
		lastNameTextField.sendKeys(lastName);
		
		saveButton.click();
	}
	
	
	
}
