package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class MobileSliderTest extends Base
{
	
	@Test
	public void checkWhetherTheUserAbletoSelectValueFromDropDown() throws InterruptedException
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnMobileSlider();
		
		MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
		mobileSliderPage.clickOnNewButton();
		mobileSliderPage.clickOnTheCategoryDropDownBox();
		
		WebElement categoryDropDown = driver.findElement(By.xpath("//select[@id='cat_id']"));
		
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(categoryDropDown,"Fruits");
		mobileSliderPage.clickOnSaveButton();
		boolean isSuccessMessageDisplayed = mobileSliderPage.isSuccessAlertMessageDisplayed();
		assertTrue(isSuccessMessageDisplayed, "Not successfully saved");
		
	}

}
