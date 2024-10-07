package com.tutoninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessRegistrationPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement registrationSucceess;
	
	
	public SuccessRegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String successfulRegistration() {
		
		String successRegText=registrationSucceess.getText();
		return successRegText;
	}

}
