package com.tutoninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutoninja.qa.base.Base;
import com.tutoninja.qa.pages.HomePage;
import com.tutoninja.qa.pages.SeachedProduct;

public class SearchTest extends Base{
	public WebDriver driver;
	

	
	@BeforeMethod
	public void setUp() {
		
		driver=initializeBrowserOpenURL("chrome");
	}
	
	@AfterMethod
	public void trarDown() {
	driver.quit();
}
	
	@Test(priority=1)
	public void searchWithValidProduct() {
		
		
		HomePage HomePage=new HomePage(driver);
		HomePage.searchTextBox("HPPPPP");
		HomePage.clickOnSeacrhButton();
		
		SeachedProduct SeachedProduct= new  SeachedProduct(driver);
		SeachedProduct.searchedProduct();
		
		/*driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());*/
		
	}
	
	@Test(priority=2, dependsOnMethods= "searchWithValidProduct")
	public void searchWithInvalidProduct() {
		
		HomePage HomePage=new HomePage(driver);
		HomePage.searchTextBox("HONDA");
		HomePage.clickOnSeacrhButton();
		
		SeachedProduct SeachedProduct= new  SeachedProduct(driver);
		String expectedInvalidProductText=dataprop.getProperty("invalidProductMesssage");
		String actualInvalidProductText=SeachedProduct.nonsearchedProduct();
		Assert.assertEquals(expectedInvalidProductText,actualInvalidProductText);
		
		/*driver.findElement(By.name("search")).sendKeys("HONDA");
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String expectedInvalidProductText=dataprop.getProperty("invalidProductMesssage");
		String actualInvalidProductText=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
		Assert.assertEquals(expectedInvalidProductText,actualInvalidProductText);*/
	}
	}
