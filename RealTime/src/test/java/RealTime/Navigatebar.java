package RealTime;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class Navigatebar extends base {
	 public static Logger log=LogManager.getLogger(base.class.getName());
	 public WebDriver driver;
	@BeforeTest()
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		driver.get(prop.getProperty("url"));	
	}


	@Test()
	public void validateNavigationbar() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		
		Assert.assertTrue(l.navigationBar().isDisplayed());
		log.info("Navigate to home Page is displayed");
		
	}
	@AfterTest()
	public void tearDown()
	{
		driver.close();
		
	}
}
