package com.obsqura.rmartSuperMarket;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class ManageCategoryTest extends Base
{
	@Test
	public void verifyWhetherTheUserAbleToAddValuesInManageCategory()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageCategory();
		menuSelectionPage.clickOnCategorySubMenuOfManageCategory();
		
		ManageCategoryPage manageCategoryPage = new ManageCategoryPage(driver);
		manageCategoryPage.clickOnNewButton();
		manageCategoryPage.enterValueInCategoryField();
		manageCategoryPage.clickOnSelectGroup();
		manageCategoryPage.uploadFile();
		manageCategoryPage.clickOnNoRadioButtonOfShowOnTopMenuField();
		manageCategoryPage.clickOnNoRadioButtonOfShowOnLeftMenuField();
		manageCategoryPage.clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageCategoryPage.successalertMessageDisplay();
		assertTrue(isAlertMessageDisplayed, "Some issue while adding the doc or link");
	}

}
