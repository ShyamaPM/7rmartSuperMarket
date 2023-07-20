package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginPage extends Base
{
	@Test
	public void verifyTheUserAbleToLoginWithValidCredentials()
	{
		String userName = "admin";
		String password = "admin";
		WebElement userNameTextBox = driver.findElement(By.xpath("//input[@name='username']"));
		userNameTextBox.sendKeys(userName);
		WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
		passwordTextBox.sendKeys(password);
		WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
		signInButton.click();
		boolean findElementClassWrapper = driver.findElement(By.className("wrapper")).isDisplayed();
		boolean dashbordTextIsDisplayed = driver.findElement(By.xpath("//li[text()='Dashboard']")).isDisplayed();
		assertTrue(findElementClassWrapper, "The displayed window is not Dashborad");
		assertTrue(dashbordTextIsDisplayed, "The displayed window is not dashboard");
	}
	
	@Test
	public void verifyTheUserCannotLoginWithValidUserNameandInvalidPassword()
	{
		String userName = "admin";
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
