package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base
{
	@BeforeMethod
	public void verifyTheUserAbleToLoginWithValidCredentials()
	{
		String userName = "admin";
		String password = "admin";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswrodOnPasswrodField(password);
		loginPage.clickOnSignInButton();
		boolean isNavigatedToHomePage = loginPage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"Not navigated to homepage");
	}
	
	@Test
	public void verifyTheUserCannotLoginWithValidUserNameandInvalidPassword()
	{
		String userName = "admin";
		String password = "test";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswrodOnPasswrodField(password);
		loginPage.clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User able to navigate to homepage");
	}

	@Test
	public void verifyTheUserCannotLoginWithInvalidUserNameandValidPassword()
	{
		String userName = "Test";
		String password = "admin";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswrodOnPasswrodField(password);
		loginPage.clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User able to navigate to homepage");
	}
	
	@Test
	public void verifyTheUserCannotLoginWithInvalidUserNameandInvalidPassword()
	{
		String userName = "Tester";
		String password = "test";
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName);
		loginPage.enterPasswrodOnPasswrodField(password);
		loginPage.clickOnSignInButton();
		boolean isAlertMessageDisplayed = loginPage.isAlertMessageDisplayedAfterEnteringInvalidCredentials();
		assertTrue(isAlertMessageDisplayed, "User able to navigate to homepage");
	}
}
