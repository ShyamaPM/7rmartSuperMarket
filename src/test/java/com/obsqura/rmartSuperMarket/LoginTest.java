package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test
	public void verifyTheUserAbleToLoginWithValidCredentials()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		boolean isNavigatedToHomePage = loginPage.isHomePageDisplayed();
		assertTrue(isNavigatedToHomePage,"Not navigated to homepage");
	}
	
	@Test
	public void verifyTheUserCannotLoginWithValidUserNameandInvalidPassword()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(2, 0,"LoginPage");
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
		String userName = ExcelUtility.getString(2, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
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
