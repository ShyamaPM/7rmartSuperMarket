package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.ManageExpensePage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import utilities.ExcelUtility;

public class ManageExpenseTest extends Base
{
	@Test
	public void verifyWhetherUserAbletoSubmitTheManageExpence()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageExpense();
		menuSelectionPage.clickOnSubMenuManageExpense();
		
		ManageExpensePage manageExpensePage = new ManageExpensePage(driver);
		manageExpensePage.clickOnNewButton().selectUserDropDown().selectCategory().selectOrderId().selectPurchaseId()
		   .selectExpenseType().enterAmount().enterRemarksData().uploadFile().clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageExpensePage.alertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed, "Submission failed");
	}

}
