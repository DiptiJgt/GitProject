package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By login=By.cssSelector("a[href*='sign_in']");
	
	By title=By.cssSelector("div.text-center");
	By navBar=By.cssSelector("div.container");
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement navigationBar()
	{
		return driver.findElement(navBar);
	}

	

}
