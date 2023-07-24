package com.obsqura.rmartSuperMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileSliderPage 
{
	 public WebDriver driver;
		
		public MobileSliderPage(WebDriver driver) 
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (xpath = "//a[@onclick='click_button(1)']") private WebElement newButton;
		@FindBy (xpath = "//select[@id='cat_id']")public WebElement categoryDropDown;
		@FindBy(xpath = "//button[@name='create']") private WebElement saveButton;
		@FindBy(xpath = "//i[@class='icon fas fa-check']") private WebElement alertMessage;
		
		
		public void clickOnNewButton()
		{
			newButton.click();
		}
		public void clickOnTheCategoryDropDownBox()
		{
			categoryDropDown.click();
		}
		public void clickOnSaveButton()
		{
			saveButton.click();
		}
		
		public boolean isSuccessAlertMessageDisplayed()
		{
			return alertMessage.isDisplayed();
		}
}
