package com.tutoninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutoninja.qa.utils.ExtentsReporter;
import com.tutoninja.qa.utils.Utilities;

public class MyListener  implements ITestListener {

	
	WebDriver driver;
	//To take below methods - Source-overide/implements methods 
	ExtentReports extentReports ;
	ExtentTest extentTest;
	String textName;
	
	@Override
	public void onStart(ITestContext context) {
		
		try {
			 extentReports =ExtentsReporter.generateExtentReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		textName  = result.getName(); 	
		extentTest =extentReports.createTest(textName);
		extentTest.log(Status.INFO, textName +" is started executing");
		}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		extentTest.log(Status.PASS, textName +" is successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   String destiPath=Utilities.Screenshot(driver, textName);
				
		extentTest.addScreenCaptureFromPath(destiPath);
		extentTest.log(Status.FAIL, textName +" is skipped" );
		extentTest.log(Status.INFO, result.getThrowable() );
		
		System.out.println(textName+ "Snap Taken");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		extentTest.log(Status.SKIP, textName +" is skipped" );
		extentTest.log(Status.INFO, result.getThrowable() );
	
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		
		//Capture path of report ..this is URL 
		String PathOfExtentReport= System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html";
		File file= new File(PathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
