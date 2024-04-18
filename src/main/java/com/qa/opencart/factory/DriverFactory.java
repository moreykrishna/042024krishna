package com.qa.opencart.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverFactory 
{
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	
	public static String highlight;
	
	/*
	 * this method is used to initialize the webdriver
	 * @param browser name
	 * @return this will return the driver
	 */
	
	public WebDriver initDriver(Properties prop) {
		optionsManager = new OptionsManager(prop);
		highlight=prop.getProperty("highlight").trim();
		String browserName= prop.getProperty("browser").trim().toLowerCase();
		System.out.println("Browser name is :" +browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver(optionsManager.getChromeOptions());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver(optionsManager.getFirefoxOptions());
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
	    }
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver(optionsManager.getEdgeOptions());
	    }
		else
		{
			System.out.println("please pass the right browser:"+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.get(prop.getProperty("url"));
		return driver;
	}
	/**
	 * this method reading the properties from the property file
	 * @return
	 */
	public Properties initprop()
	{
		prop= new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
}
