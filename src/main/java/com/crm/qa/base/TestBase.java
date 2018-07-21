package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver ;
	public static Properties prop;
//
	public TestBase() {
	
		try {
	 prop = new Properties();
	 FileInputStream ip = new  FileInputStream ("/Users/nejlagulsaglam/testing-maven/CRMtest/src/main/java/com/crm/qa/config/config.properties");
	
	prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initiliazition() {
	String browserName	= prop.getProperty("browser");
	if(browserName.equals("chrome")) {
	      System.setProperty("webdriver.chrome.driver" ,"/Users/nejlagulsaglam/Documents/selenium dependencies/drivers/chromedriver" );
	driver = new ChromeDriver();
	
	}else if (browserName.equals("FF")) {
		System.setProperty("webdriver.gecko.driver", "/Users/nejlagulsaglam/Documents/selenium dependencies/drivers/geckodriver");
		driver = new FirefoxDriver();
	}
	driver.manage().window().fullscreen();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
}
}