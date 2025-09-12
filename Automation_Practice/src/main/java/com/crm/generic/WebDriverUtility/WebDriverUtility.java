package com.crm.generic.WebDriverUtility;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

//	WebDriver driver=null;
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to wait for element to be identified.
	 * @param driver
	 */
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to wait for condition to be identified.
	 * @param driver
	 */
	public void explicitwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**@author Subrat Kumar Sahoo
	 * This method is used to wait for loading of webpage.
	 * @param driver
	 */
	public void pageLoadTime(WebDriver driver)
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	}
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to maximize the browser window.
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to switch the control to the window based on the title.
	 * @param driver
	 * @param partitle
	 */
	public void switchToWindowOnTitle(WebDriver driver,String partitle)
	{
		Set<String> allIds=driver.getWindowHandles();
		
		for(String id:allIds)
		{
			driver.switchTo().window(id);
			
			String title=driver.getTitle();
			
			if(title.contains(partitle))
				break;
		}
	}
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to switch the control to the window based on the URL.
	 * @param driver
	 * @param partitle
	 */
	public void switchToWindowOnURL(WebDriver driver,String parURL)
	{
		Set<String> allIds=driver.getWindowHandles();
		
		for(String id:allIds)
		{
			driver.switchTo().window(id);
			
			String title=driver.getTitle();
			
			if(title.contains(parURL))
				break;
		}
	}
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to select the options present in the dropdown based on the index.
	 * @param element
	 * @param index
	 */
	public void selectByIndex(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	

	/**@author Subrat Kumar Sahoo
	 * This method is used to select the options present in the dropdown based on the value.
	 * @param element
	 * @param index
	 */
	public void selectByValue(WebElement element,String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	

	/**@author Subrat Kumar Sahoo
	 * This method is used to select the options present in the dropdown based on the visible text.
	 * @param element
	 * @param index
	 */
	public void selectByVisibleText(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to perform right click operation on the element.
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		
		act.contextClick(element).perform();
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to perform right click operation on the element.
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		
		act.doubleClick(element).perform();
	}
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to perform mousehover operation on the element.
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to perform mouse hover operation on the element based on x and y co-ordinates.
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		
		act.moveByOffset(x,y).perform();
	}
	
	/** @author Subrat Kumar Sahoo
	 * This method is used to perform drag and drop operation on the element.
	 * @param driver
	 * @param element
	 */
	public void dragAndDrop(WebDriver driver,WebElement source,WebElement target)
	{
		Actions act=new Actions(driver);
		
		act.dragAndDrop(source,target).perform();
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used switch the control from window to alert.
	 * @param driver
	 */
	public Alert switchToAlert(WebDriver driver)
	{
		return driver.switchTo().alert();
	}
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to switch the control from window to frame based on the index.
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to switch the control from window to frame based on the nameOrId.
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to switch the control from window to frame based on the element.
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	
}
