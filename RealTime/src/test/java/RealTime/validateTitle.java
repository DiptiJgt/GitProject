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


public class validateTitle extends base{
	
	 public static Logger log=LogManager.getLogger(base.class.getName());
	 public WebDriver driver;
	@BeforeTest()
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		log.info("Driver is intialized");
		driver.get(prop.getProperty("url"));	
		log.info("Navigate to home Page");
	}

	@Test()
	public void validateTitleOfIt() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES123");
		log.info("Succesfully Validated");
		
		
	}
	@AfterTest()
	public void tearDown()
	{
		driver.close();
		
	}
	

}
