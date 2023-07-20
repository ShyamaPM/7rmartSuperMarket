package com.obsqura.rmartSuperMarket;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhij\\OneDrive\\Documents\\Eclipse_Workspace\\7rmartSuperMarket\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void browserQuit()
	{
		driver.quit();
	}

}
