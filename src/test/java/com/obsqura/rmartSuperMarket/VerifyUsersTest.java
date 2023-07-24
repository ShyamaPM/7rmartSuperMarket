package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class VerifyUsersTest extends LoginTest
{
	@Test
	public void verifyTheUserExistsInTheVerifyUsersList()
	{
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/verify-users");
		String name = "Chinchu Balachandran";
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox();
		verifyUsersPage.enterNameinSearchField(name);
		verifyUsersPage.clickOnSearchButton();
		String actualResult = verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList();
		assertEquals(name, actualResult,"The entered name is not exists in the actual result");	
	}
	
	@Test
	public void checkingSearchFunctioanlity() throws InterruptedException
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		String name = "Chinchu Balachandran";
		boolean flag = false;
		List<String> nameList = new ArrayList<>();
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/verify-users");
		WebElement searchBox = driver.findElement(By.xpath("//a[contains(@class,'btn-rounded')]"));
		searchBox.click();
		WebElement nameSearchBox = driver.findElement(By.xpath("//input[@id='un']"));
		nameSearchBox.sendKeys(name);
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'table-bordered')]"));
		List<WebElement> tableData = table.findElements(By.xpath("//td"));
		for(WebElement rowValue:tableData)
		{
			String getTextData = rowValue.getText();
			nameList.add(getTextData);
			if(nameList.contains(name))
			{
				flag = true;
			    break;
			}
		}
		WebElement searchButtonClick = driver.findElement(By.xpath("//button[@name='Search']"));
		searchButtonClick.click();
	}

}
