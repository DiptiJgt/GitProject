package resources;


import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver intializeDriver() throws IOException
	{
		 prop=new Properties();
	FileInputStream ip=new FileInputStream("C:\\Users\\Pankaj Arora\\eclipse-workspace\\RealTime\\src\\main\\java\\resources\\config.Properties");
	prop.load(ip);
	String browserName=prop.getProperty("browser");
	//String browserName="chrome";
	if(browserName.contains("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Pankaj Arora\\eclipse-workspace\\Learn\\resources\\chromedriver.exe");
		 driver=new ChromeDriver();
	}
	else if (browserName.contains("FF"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Pankaj Arora\\eclipse-workspace\\Learn\\resources\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	return driver;
	}
	
	
	public void getScreenShotPath(String TestCaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot take=(TakesScreenshot) driver;
		File source=take.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+TestCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		
	}
}
