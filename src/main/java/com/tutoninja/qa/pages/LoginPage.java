package com.tutoninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement emailInputBox;
	
	@FindBy(id="input-password")
	private WebElement PassworInputdBox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement InvalidEmailWarningText;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement InvalidPasswordWarningText;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendValidEmailId(String email) {
		emailInputBox.sendKeys(email);
	}
	
	public void sendValidPassword(String password) {
		PassworInputdBox.sendKeys(password);
	}

	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public String InvalidEmailWarning() {
		String invalidEmailWarningTextMessage =InvalidEmailWarningText.getText();
		return invalidEmailWarningTextMessage;
	}
	public String InvalidPasswordWarning() {
		String invalidPasswordWarningTextMessage =InvalidEmailWarningText.getText();
		return invalidPasswordWarningTextMessage;
	}
	
	
	
}
