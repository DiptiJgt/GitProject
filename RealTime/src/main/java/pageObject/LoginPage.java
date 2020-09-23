package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By email=By.cssSelector("input[id='user_email']");
	By password=By.cssSelector("input[type='password']");
	By submit=By.cssSelector("input[name='commit']");		
	
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
}
