package RealTime;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends  base {
	 public static Logger log=LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest()
	public void intialize() throws IOException
	{
		driver=intializeDriver();
		
	}
	@AfterTest()
	public void tearDown()
	{
		driver.close();
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName,String Password,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));	
		LandingPage l=new LandingPage(driver);
		l.login().click();
		LoginPage as=new LoginPage(driver);
		as.getEmail().sendKeys(UserName);
		as.getPassword().sendKeys(Password);
		log.info(text);
		as.getSubmit().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
	   Object data[][]=new Object[2][3];
	   data[0][0]="nonrestrication.com";
	   data[0][1]="1234";
	   data[0][2]="non restricted";
	   
	   
	   data[1][0]="restrictedusre.com";
	   data[1][1]="121456";
	   data[1][2]="restricted";
	   return data;
	}
	 

}
