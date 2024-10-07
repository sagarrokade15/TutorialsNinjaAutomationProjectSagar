 package com.tutoninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutoninja.qa.base.Base;
import com.tutoninja.qa.pages.AccountPage;
import com.tutoninja.qa.pages.HomePage;
import com.tutoninja.qa.pages.LoginPage;
import com.tutoninja.qa.utils.Utilities;



public class LoginTest extends Base {

	public LoginTest() {
		super();
	}
	
public WebDriver driver;
	
	@AfterMethod
		public void tearDown()   {
		driver.quit();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializeBrowserOpenURL(prop.getProperty("browserName"));
		
		HomePage homepage= new HomePage(driver);
		homepage.clickOnMyAccountDropdown();
		homepage.clickOnLoginDropdown();
		
		
		//driver.findElement(By.xpath("//a[@title='My Account']")).click();
		///driver.findElement(By.linkText("Login")).click();
				
}
	@Test(priority=1)
	public void validLogin() {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendValidEmailId(prop.getProperty("validEmail"));
		loginpage.sendValidPassword(prop.getProperty("validUserPassword"));
		loginpage.clickOnLoginButton();
		
		AccountPage AccountPage= new AccountPage(driver);
		AccountPage.DisplayTextAfterSuccessfulLOgin();
		
		/*driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validUserPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());*/
				}
	
	@Test(priority=2)
public void invalidEmailLogin() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendValidEmailId(Utilities.generateEmail());
		loginpage.sendValidPassword(prop.getProperty("validUserPassword"));
		loginpage.clickOnLoginButton();
		
		String expectedWarningText=dataprop.getProperty("invalidEmaildWarningMessage");
		String actualWarningText=loginpage.InvalidEmailWarning();
		Assert.assertEquals(actualWarningText, expectedWarningText);
	
	/*driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmail());
	driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validUserPassword"));
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String expectedWarningText=dataprop.getProperty("invalidEmaildWarningMessage");
	String actualWarningText=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	Assert.assertEquals(actualWarningText, expectedWarningText);*/
	
	
	}
	@Test(priority=3)
public void invalidPasswordLogin() {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendValidEmailId(prop.getProperty("validEmail"));
		loginpage.sendValidPassword(dataprop.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		
		String expectedWarningText=dataprop.getProperty("invalidPasswordWarningMessage");
		String actualWarningText=loginpage.InvalidPasswordWarning();
		Assert.assertEquals(actualWarningText, expectedWarningText);
		
		
	/*driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
	driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String expectedWarningText=dataprop.getProperty("invalidPasswordWarningMessage");
	String actualWarningText=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
	Assert.assertEquals(actualWarningText, expectedWarningText);*/
		
	}
	

	@Test(priority=4,dataProvider="validData")
	public void loginFromXcelData(String email,String password) {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.sendValidEmailId(email);
		loginpage.sendValidPassword(password);
		loginpage.clickOnLoginButton();
		
		AccountPage AccountPage= new AccountPage(driver);
		AccountPage.DisplayTextAfterSuccessfulLOgin();
	}
		
		
		/*driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		}*/
	
	@DataProvider(name="validData")
	public Object supplyData() { 
		Object [][] data= Utilities.getDataFromXcel("LoginData");
				
		return data;

	
}
	}