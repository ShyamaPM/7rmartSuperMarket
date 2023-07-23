package com.obsqura.rmartSuperMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class VerifyUsersPage {
	WebDriver driver;
	
	public VerifyUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[contains(@class,'btn-rounded')]") private WebElement searchBox;
	@FindBy ( xpath = "//input[@id='un']") private WebElement nameTextField;
	@FindBy (xpath = "//button[@name='Search']") private WebElement searchButton;
	@FindBy (xpath = "//table[contains(@class,'table-bordered')]//td") private WebElement tableValues;
	
	
	public void clickOnSearchBox()
	{
		searchBox.click();
	}

	public void enterNameinSearchField(String name)
	{
	nameTextField.sendKeys(name);
	}
	
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	public boolean isTheSearcNameExistsInTheVerifyUsersList() 
	{
		return tableValues.isDisplayed();
		
	}
}
