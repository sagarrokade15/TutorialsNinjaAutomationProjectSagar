package com.tutoninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	//Object
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText="Login")
	private WebElement loginDropdown;
	
	@FindBy(linkText="Register")
	private WebElement registerDropdown;
	
	@FindBy(name="search")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement seachButton;

	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	
	public void clickOnMyAccountDropdown() {
		myAccountDropdown.click();
	}
	
	public void clickOnLoginDropdown() {
		loginDropdown.click();
	}
	
	public void clickOnRegisterDropdown() {
		registerDropdown.click();
	}
	
	public void searchTextBox(String prodName) {
		searchTextBox.sendKeys(prodName);
	}
	
	public void clickOnSeacrhButton() {
		seachButton.click();
	}
}
