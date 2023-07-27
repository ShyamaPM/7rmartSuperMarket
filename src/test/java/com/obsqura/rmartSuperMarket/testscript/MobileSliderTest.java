package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import com.obsqura.rmartSuperMarket.pages.MobileSliderPage;
import utilities.ExcelUtility;

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
		//menuSelectionPage.toGetAllTheSubMenus("Mobile Slider");
		
		MobileSliderPage mobileSliderPage = new MobileSliderPage(driver);
		mobileSliderPage.clickOnNewButton();
		mobileSliderPage.clickOnTheCategoryDropDownBox();
		mobileSliderPage.selectValueFromCategoryDropDown();
		mobileSliderPage.uploadFileByClickingOnChooseFileButton();
		mobileSliderPage.clickOnSaveButton();
			
		boolean isSuccessMessageDisplayed = mobileSliderPage.isSuccessAlertMessageDisplayed();
		assertTrue(isSuccessMessageDisplayed, "Not successfully saved");
		
	}

}
