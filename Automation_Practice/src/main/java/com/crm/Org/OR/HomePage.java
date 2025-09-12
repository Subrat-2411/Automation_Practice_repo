package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@value='Search...']")
	private WebElement searchTextField;
	
	@FindBy(xpath="//img[contains(@src,'Home.PNG')]")
	private WebElement homeIcon;
	
	@FindBy(xpath="//a[text()='Leads' and contains(@href,'action=index')]")
	private WebElement leadsLink;
	
	@FindBy(xpath="//a[text()='Calendar']")
	private WebElement  calendarLink;

	@FindBy(xpath="//a[text()='Organizations' and contains(@href,'action=index')]")
	private WebElement organizationLink;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactsLink;
	
	
	@FindBy(xpath="//a[text()='Opportunities' and contains(@href,'action=index')]")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productsLink;
	
	@FindBy(xpath="//a[text()='Documents']")
	private WebElement documentsLink;
	

	@FindBy(xpath="//a[text()='Email']")
	private WebElement emailsLink;
	

	@FindBy(xpath="//a[text()='Trouble Tickets' and contains(@href,'action=index')]")
	private WebElement troubleTicketsLink;
	

	@FindBy(xpath="//a[text()='Dashboard']")
	private WebElement dashboardLink;
	

	@FindBy(xpath="//a[contains(text(),'More')  and contains(@href,'java')]")
	private WebElement moreLink;
	
	@FindBy(xpath="//select[@id='qccombo']")
	private WebElement quickCreateDropdown;
	
	@FindBy(name="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//img[contains(@src,'softed/images/user.PNG')]")
	private WebElement administratorIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logOutLink;


	public HomePage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver,this);
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}
	
	public WebElement getAdministratorIcon() {
		return administratorIcon;
	}
	
	public WebElement getLogOutLink() {
		return logOutLink;
	}
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getHomeIcon() {
		return homeIcon;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailsLink() {
		return emailsLink;
	}

	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	

	public WebElement getQuickCreateDropdown() {
		return quickCreateDropdown;
	}
	

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public void logOut()
	{
		Actions act=new Actions(driver);
		
		act.moveToElement(administratorIcon).click(logOutLink).perform();
		
	}
	
	public void quickCreateAction(String actionName)
	{
		Select sel=new Select(quickCreateDropdown);
		
		sel.selectByValue(actionName);
		
		
	}
	
	public void openCampaign()
	{
        Actions act=new Actions(driver);
		
		act.moveToElement(moreLink).click(campaignsLink).perform();
	}
}
