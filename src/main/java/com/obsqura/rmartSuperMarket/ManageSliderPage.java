package com.obsqura.rmartSuperMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;
import utilities.GeneralUtility;
import utilities.UploadFileUtility;

public class ManageSliderPage 
{

	public WebDriver driver;
	
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath = "//input[@id='main_img']") private WebElement fileUploadButton;
	@FindBy(xpath = "//input[@id='link']") private WebElement linkTextField;
	@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]") private WebElement alertMessage;
	
	
	public void newButtonClick()
	{
		newButton.click();
	}
	public void uploadFileByCLickingOnFileUplaodButton()
	{
		UploadFileUtility uploadFileUtility = new UploadFileUtility();
		uploadFileUtility.fileUploadUsingSendKeys(fileUploadButton, GeneralUtility.IMAGEFILEFORMANAGECATEGORYCATEGORYPAGE);
	}
	public void enterTextDataInLinkTextField()
	{
		linkTextField.sendKeys(ExcelUtility.getString(0, 0, "ManageSlider"));
	}
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	public boolean successalertMessageDisplay() 
	{
		return alertMessage.isDisplayed();
	}
	

}
