package com.tutoninja.qa.testcases;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutoninja.qa.base.Base;
import com.tutoninja.qa.pages.HomePage;
import com.tutoninja.qa.pages.RegisterPage;
import com.tutoninja.qa.pages.SuccessRegistrationPage;
import com.tutoninja.qa.utils.Utilities;

public class RegisterTest extends Base {

public WebDriver driver;
	
public RegisterTest() {
	super();
}

	@AfterMethod
		public void tearDown() {
		driver.quit();
	}
	
	@BeforeMethod
	public void setUp() {
		
		driver=initializeBrowserOpenURL("chrome");
		
		HomePage homepage= new HomePage(driver);
		
		homepage.clickOnMyAccountDropdown();
		homepage.clickOnRegisterDropdown();
	}
	
	

	@Test(priority=1)
	public void verifyAccountWithMandatoryFields() {
		
		RegisterPage RegisterPage=new RegisterPage(driver);
		RegisterPage.inputFname(dataprop.getProperty("firstName"));
		RegisterPage.inputLname(dataprop.getProperty("lastName"));
		RegisterPage.inputEmail(Utilities.generateEmail());
		RegisterPage.inputTelephone(dataprop.getProperty("telephone"));
		RegisterPage.inputPassword(prop.getProperty("validUserPassword"));
		RegisterPage.inputConfirmPassword(prop.getProperty("validUserPassword"));
		RegisterPage.selectCheckbox();
		RegisterPage.clickSubmitButton();
		
		SuccessRegistrationPage SuccessRegistrationPage=new SuccessRegistrationPage(driver);
		
		String actualSuccessText=SuccessRegistrationPage.successfulRegistration();
		String expectedSuccessText=dataprop.getProperty("successfulRegMessage");
		assertEquals(actualSuccessText, expectedSuccessText);
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validUserPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validUserPassword"));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualSuccessText=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		String expectedSuccessText=dataprop.getProperty("successfulRegMessage");
		assertEquals(actualSuccessText, expectedSuccessText);*/
		
	}
	@Test(priority=2)
	public void verifyAccountWithoutSelectingCheckbox() {
		
		RegisterPage RegisterPage=new RegisterPage(driver);
		RegisterPage.inputFname(dataprop.getProperty("firstName"));
		RegisterPage.inputLname(dataprop.getProperty("lastName"));
		RegisterPage.inputEmail(Utilities.generateEmail());
		RegisterPage.inputTelephone(dataprop.getProperty("telephone"));
		RegisterPage.inputPassword(prop.getProperty("validUserPassword"));
		RegisterPage.inputConfirmPassword(prop.getProperty("validUserPassword"));
		RegisterPage.clickSubmitButton();
	    String actualWarningCheckboxText=RegisterPage.selectionCheckboxErrorMessage();
		String expectedWarningCheckboxText=dataprop.getProperty("warningMesssageForCheckbox");
		assertEquals(actualWarningCheckboxText, expectedWarningCheckboxText);
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validUserPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validUserPassword"));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualWarningCheckboxText=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningCheckboxText=dataprop.getProperty("warningMesssageForCheckbox");
		assertEquals(actualWarningCheckboxText, expectedWarningCheckboxText);*/
		
	}
	@Test(priority=3)
	
	public void verifyAccountWithAlreadyRegisteredEmail() {
		
		RegisterPage RegisterPage=new RegisterPage(driver);
		RegisterPage.inputFname(dataprop.getProperty("firstName"));
		RegisterPage.inputLname(dataprop.getProperty("lastName"));
		RegisterPage.inputEmail(prop.getProperty("validEmail"));
		RegisterPage.inputTelephone(dataprop.getProperty("telephone"));
		RegisterPage.inputPassword(prop.getProperty("validUserPassword"));
		RegisterPage.inputConfirmPassword(prop.getProperty("validUserPassword"));
		RegisterPage.selectCheckbox();
		RegisterPage.clickSubmitButton();
		
		String actualEmailWarningText=RegisterPage.alreadyRegemailMessage();
		String expectedEmailWarningText=dataprop.getProperty("WarningMessagForRegisteredEmail");
		assertEquals(actualEmailWarningText, expectedEmailWarningText);
		
		
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys("sagarrokade155@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validUserPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validUserPassword"));
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String actualEmailWarningText=driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedEmailWarningText=dataprop.getProperty("WarningMessagForRegisteredEmail");
		assertEquals(actualEmailWarningText, expectedEmailWarningText);
		*/
	}
}
