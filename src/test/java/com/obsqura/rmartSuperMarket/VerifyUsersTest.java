package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class VerifyUsersTest extends LoginTest
{
	@Test
	public void verifyTheUserExistsInTheVerifyUsersList()
	{
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/verify-users");
		String name = "Chinchu";
		VerifyUsersPage verifyUsersPage = new VerifyUsersPage(driver);
		verifyUsersPage.clickOnSearchBox();
		verifyUsersPage.enterNameinSearchField(name);
		verifyUsersPage.clickOnSearchButton();
		boolean isSearchUserIsDisplayed = verifyUsersPage.isTheSearcNameExistsInTheVerifyUsersList();
		assertTrue(isSearchUserIsDisplayed,"The entered name is not exists in the list");
	}
	
	@Test
	public void checkingSearchFunctioanlity() throws InterruptedException
	{
		String name = "test";
		List<String> nameList = new ArrayList<>();
		driver.navigate().to("https://groceryapp.uniqassosiates.com/admin/verify-users");
		WebElement searchBox = driver.findElement(By.xpath("//a[contains(@class,'btn-rounded')]"));
		searchBox.click();
		WebElement table = driver.findElement(By.xpath("//table[contains(@class,'table-bordered')]"));
		//List<WebElement> columnName = table.findElements(By.xpath("//th"));
		List<WebElement> tableData = table.findElements(By.xpath("//td"));
		for(WebElement rowValue:tableData)
		{
			String getTextData = rowValue.getText();
			nameList.add(getTextData);
			WebElement nameSearchBox = driver.findElement(By.xpath("//input[@id='un']"));
			nameSearchBox.sendKeys(name);
			Thread.sleep(1000);
			break;
		}
		WebElement searchButtonClick = driver.findElement(By.xpath("//button[@name='Search']"));
		searchButtonClick.click();
		Thread.sleep(1000);
	}

}
