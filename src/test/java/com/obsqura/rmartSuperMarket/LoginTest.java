package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends Base
{
	@Test
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
		boolean isInvalidUserNameorPasswordDisplayed = driver.findElement(By.xpath("//div[contains(@class,'-dismissible')]")).isDisplayed();
		assertTrue(isInvalidUserNameorPasswordDisplayed, "The enter username and password is correct");
	}

	@Test
	public void verifyTheUserCannotLoginWithInvalidUserNameandValidPassword()
	{
		String userName = "Test";
		String password = "admin";
		WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='username']"));
		userNameTextBox.sendKeys(userName);
		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextBox.sendKeys(password);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		boolean isInvalidUserNameorPasswordDisplayed = driver.findElement(By.xpath("//div[contains(@class,'-dismissible')]")).isDisplayed();
		assertTrue(isInvalidUserNameorPasswordDisplayed, "The enter username and password is correct");
	}
	
	@Test
	public void verifyTheUserCannotLoginWithInvalidUserNameandInvalidPassword()
	{
		String userName = "Tester";
		String password = "test";
		WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='username']"));
		userNameTextBox.sendKeys(userName);
		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextBox.sendKeys(password);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		boolean isInvalidUserNameorPasswordDisplayed = driver.findElement(By.xpath("//div[contains(@class,'-dismissible')]")).isDisplayed();
		assertTrue(isInvalidUserNameorPasswordDisplayed, "The enter username and password is correct");
	}
}
