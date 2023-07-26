package com.obsqura.rmartSuperMarket;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.GeneralUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fs;
	
	@BeforeMethod
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception
	{
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(GeneralUtility.CONFIGfILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();

		}
		else if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();

		}

		else if (browser.equalsIgnoreCase("edge")) 
		{
			driver = WebDriverManager.edgedriver().create();
		} 
		else 
		{
			throw new Exception("Browser is not correct");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
	}
	
	@AfterMethod
	public void browserQuit()
	{
		driver.quit();
	}

}
