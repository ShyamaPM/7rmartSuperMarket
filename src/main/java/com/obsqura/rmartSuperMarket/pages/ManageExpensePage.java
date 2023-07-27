package com.obsqura.rmartSuperMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;

public class ManageExpensePage 
{
	public WebDriver driver;
	
	public ManageExpensePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//select[@name='user_id']") private WebElement userDropDown;
	@FindBy(xpath = "//input[@id='ex_date']") private WebElement datePicker;
	@FindBy(xpath = "//select[@name='ex_cat']") private WebElement categoryDropDown;
	@FindBy(xpath = "//select[@name='order_id']") private WebElement orderIDDropDown;
	@FindBy(xpath = "//select[@name='purchase_id']") private WebElement purchaseIDDropDown;
	@FindBy(xpath = "//select[@name='ex_type']") private WebElement expenseTypeDropDown;
	@FindBy(xpath = "//input[@name='amount']") private WebElement amountTextField;
	@FindBy(xpath = "//textarea[@name='remarks']") private WebElement remarksTextField;
	@FindBy(xpath = "//input[@name='userfile']") private WebElement chooseFileButton;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;

	public ManageExpensePage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageExpensePage selectUserDropDown()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(userDropDown, ExcelUtility.getString(0, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectCategory()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(categoryDropDown, ExcelUtility.getString(1, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectOrderId()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(orderIDDropDown, ExcelUtility.getNumeric(2, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectPurchaseId()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(purchaseIDDropDown, ExcelUtility.getNumeric(3, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage selectExpenseType()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(expenseTypeDropDown, ExcelUtility.getString(4, 1,"ManageExpense"));
		return this;
	}
	public ManageExpensePage enterAmount()
	{
		amountTextField.sendKeys(ExcelUtility.getNumeric(5, 1, "ManageExpense"));
		return this;
	}
	public ManageExpensePage enterRemarksData()
	{
		remarksTextField.sendKeys(ExcelUtility.getString(6, 1, "ManageExpense"));
		return this;
	}
	public ManageExpensePage uploadFile()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		chooseFileButton.sendKeys(GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
		return this;
	}
	public ManageExpensePage clickOnSaveButton()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.scrollBy(driver);
		saveButton.click();
		return this;
	}
	public boolean alertMessageIsDisplayed()
	{
		return alertMessage.isDisplayed();
	}
	
}
