package com.crm.Org.OR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;

	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userNameTextField;

	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordTextField;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	// Initialization is happening here 
	public LoginPage(WebDriver driver) {

		this.driver=driver;
		
		PageFactory.initElements(driver,this);// load and initialize all the elements
	}

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {// Lazy Initialization happens based on the current address at the runtime
		return loginButton;
	}
	
	public void login(String userName,String password)
	{
		driver.manage().window().maximize();
		
		userNameTextField.sendKeys(userName);
		
		passwordTextField.sendKeys(password);
		
		loginButton.click();

	}
	
	
}
