package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClosedShadowPage {

	@FindBy(xpath="//h1[text()='Login']")
	private WebElement loginButton;
	
	public ClosedShadowPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
}
