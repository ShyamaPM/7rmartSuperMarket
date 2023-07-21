package com.obsqura.rmartSuperMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='username']") private WebElement userNameFiled;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") private WebElement signInButton;
	@FindBy(xpath = "//li[text()='Dashboard']") private WebElement homePage;
	 
	public void enterUsernameOnUsernameField(String userName)
	{
		userNameFiled.sendKeys(userName);
	}
	
	public void enterPasswrodOnPasswrodField(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void clickOnSignInButton()
	{
		signInButton.click();
	}
	
	public boolean isHomePageDisplayed()
	{
		return homePage.isDisplayed();
	}
	
	

}
