package com.obsqura.rmartSuperMarket;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;
import utilities.UploadFileUtility;
import utilities.WaitUtility;

public class ManageCategoryPage 
{
public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='category']") private WebElement categoryTextField;
	@FindBy(xpath = "//li[@id='134-selectable']") private WebElement selectDiscount;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement chooseFileButton;
	@FindBy(xpath = "//input[@name='top_menu' and @value='no']") private WebElement showOnTopMenuNoRadioButton;
	@FindBy(xpath = "//input[@name='show_home' and @value='no']") private WebElement showOnLeftMenuNoRadioButton;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	public void clickOnNewButton() 
	{
		newButton.click();	
	}
	public void enterValueInCategoryField()
	{
		categoryTextField.sendKeys(ExcelUtility.getString(0, 0,"ManageCategory"));
	}
	public void clickOnSelectGroup() 
	{
		selectDiscount.click();
	}
	public void uploadFile() 
	{
		UploadFileUtility uploadFileUtility = new UploadFileUtility();
		uploadFileUtility.fileUploadUsingSendKeys(chooseFileButton,GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
	}
	public void clickOnNoRadioButtonOfShowOnTopMenuField() 
	{
		JavascriptExecutor j = (JavascriptExecutor)driver; 
		j.executeScript("scroll(0,500)");
		showOnTopMenuNoRadioButton.click();
	}
	public void clickOnNoRadioButtonOfShowOnLeftMenuField() 
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,showOnLeftMenuNoRadioButton);
		showOnLeftMenuNoRadioButton.click();
	}
	public void clickOnSaveButton() 
	{
		JavascriptExecutor j = (JavascriptExecutor)driver; 
		j.executeScript("scroll(0,500)");
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElementClickable(driver,saveButton);
		saveButton.click();
	}
	public boolean successalertMessageDisplay() 
	{
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.waitForElement(driver, alertMessage);
		return alertMessage.isDisplayed();
	}

}
