package com.tutoninja.qa.pages;

import java.lang.constant.Constable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeachedProduct {
	
	WebDriver driver ;
	
	
	@FindBy(linkText="HP LP3065")
	private WebElement searchedProd;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement nonSearchedProduct;
	
	
	
	public SeachedProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String searchedProduct() {
		String srchprod=searchedProd.getText();
		return srchprod;
	}

	public String nonsearchedProduct() {
		String nonsrchprod=nonSearchedProduct.getText();
		return nonsrchprod;
	}
}
