package com.obsqura.rmartSuperMarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class ManageLocationPage 
{
	public WebDriver driver;
	
	public ManageLocationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") private WebElement countryDropDown;
	@FindBy(xpath = "//select[@id='st_id']") private WebElement stateDropDown;
	@FindBy(xpath = "//input[@id='location']") private WebElement locationTextField;
	@FindBy(xpath = "//input[@id='delivery']") private WebElement deliveryChargeTextField;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	
	public ManageLocationPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	public ManageLocationPage selectContryFromDropDown()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(countryDropDown, ExcelUtility.getString(0, 1,"ManageLocation"));
		return this;
	}
	public ManageLocationPage selectStateFromDropDown()
	{
		PageUtility pageUtility = new PageUtility();
		pageUtility.selectDropdownbyText(stateDropDown, ExcelUtility.getString(1, 1,"ManageLocation"));
		return this;
	}
	public ManageLocationPage enterLocation()
	{
		locationTextField.sendKeys(ExcelUtility.getString(2, 1, "ManageLocation"));
		return this;
	}
	public ManageLocationPage enterDeliveryCharge()
	{
		deliveryChargeTextField.sendKeys(ExcelUtility.getNumeric(3, 1,"ManageLocation"));
		return this;
	}
	public ManageLocationPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean successalertMessageDisplay() 
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, alertMessage);
		return alertMessage.isDisplayed();
	}

}
