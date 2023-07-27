package com.obsqura.rmartSuperMarket.testscript;

import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import utilities.ExcelUtility;

public class MenuSelectionTest extends Base
{
	@Test
	public void menuSelection()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnDashBoard();
		menuSelectionPage.clickOnManageOrders();
		//menuSelectionPage.clickOnGroceries();
		menuSelectionPage.clickOnManageExpense();
		menuSelectionPage.clickOnManageProduct();
		menuSelectionPage.clickOnVerifyUsers();
		menuSelectionPage.clickOnManageUsers();
		menuSelectionPage.clickOnPushNotification();
		menuSelectionPage.clickOnManageContent();
		//menuSelectionPage.clickOnManageLocation();
		menuSelectionPage.clickOnManageSlider();
		menuSelectionPage.clickOnMobileSlider();
		menuSelectionPage.clickOnManageCategory();
		menuSelectionPage.clickOnManageOfferCode();
		menuSelectionPage.clickOnManageDeliveryBoy();
		menuSelectionPage.clickOnManagePaymentMethod();
		menuSelectionPage.clickOnAdminUsers();
		menuSelectionPage.clickOnSettings();
	}

}
