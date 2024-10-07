package com.tutoninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement inpuFirsttName;
	
	@FindBy(id="input-lastname")
	private WebElement inputLastName;
	
	@FindBy(id="input-email")
	private WebElement inputEmail;
	
	@FindBy(id="input-telephone")
	private WebElement inputTelephone;
	
	@FindBy(id="input-password")
	private WebElement inputPassword;
	
	@FindBy(id="input-confirm")
	private WebElement inputConfirmPassword;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement selectionchekboxErrorMessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alreadyRegemail;
	

	
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void inputFname(String fname) {
		inpuFirsttName.sendKeys(fname);
		}
	
	
	public void inputLname(String lname) {
		inputLastName.sendKeys(lname);
		}
	
	public void inputEmail(String email) {
		inputEmail.sendKeys(email);
		}
	public void inputTelephone(String telephone) {
		inputTelephone.sendKeys(telephone);
		}
	
	public void inputPassword(String password) {
		inputPassword.sendKeys(password);
		}
	public void inputConfirmPassword(String conpassword) {
		inputConfirmPassword.sendKeys(conpassword);
		}
	
	public void selectCheckbox() {
		checkbox.click();
		}
	
	public void clickSubmitButton() {
		submitButton.click();
		}
	
	public String selectionCheckboxErrorMessage() {
		String checkbox=selectionchekboxErrorMessage.getText();
		return checkbox;
	}
	
	public String alreadyRegemailMessage() {
		String emailText=alreadyRegemail.getText();
		return emailText;
	}
}

