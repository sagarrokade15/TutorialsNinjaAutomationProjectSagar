package com.tutoninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentsReporter {
	
	
	public static ExtentReports generateExtentReport() throws IOException {

	//Extent Report contain multiple report In that We used here ExtentSparkReporter
		
		
	ExtentReports etentsReports=  new ExtentReports() ;
	File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html");
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
	
	//Below is the method taken from from ExtentSparkReporter
	
	sparkReporter.config().setTheme(Theme.DARK);
	sparkReporter.config().setReportName("TutoNinjaTestAutomationResulttReport");
	sparkReporter.config().setDocumentTitle("Automation eport");
	sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	etentsReports.attachReporter(sparkReporter);
	
	// Now We want to add more details in Reports from ExtentReports
	
	Properties configprop= new Properties();
	File F= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutoninja\\qa\\config\\config.properties");
	FileInputStream fis = new FileInputStream(F);
	configprop.load(fis);
	
	etentsReports.setSystemInfo("Applicatio URL",configprop.getProperty("URL"));
	etentsReports.setSystemInfo("BrowserName", configprop.getProperty("browserName"));
	etentsReports.setSystemInfo("EmailID", configprop.getProperty("validEmail"));
	etentsReports.setSystemInfo("Password", configprop.getProperty("validUserPassword"));
	etentsReports.setSystemInfo("UserName", System.getProperty("user.name"));
	etentsReports.setSystemInfo("OperatingSystem", System.getProperty("os.name"));
	etentsReports.setSystemInfo("JavaVersion", System.getProperty("java.version"));
	
	return etentsReports;
	 
	
	
	
	
	

	
	
	

	
	
	}
}

