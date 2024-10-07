package com.tutoninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
 
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	public Base() {
		
		 prop = new Properties();
		 File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutoninja\\qa\\config\\config.properties");
		 
		  dataprop = new Properties();
		  File datapropfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutoninja\\qa\\testdata\\testdata.properties");
		  
		  try
		  {FileInputStream datafis = new FileInputStream(datapropfile);
		  dataprop.load(datafis);
		  }catch(Throwable e) {
			  e.printStackTrace();
		  }
		 
		 try {FileInputStream fis = new FileInputStream(propfile);
		 prop.load(fis);
		 }catch(Throwable e) {
			e.printStackTrace();
			 
		 }
	}

	public WebDriver initializeBrowserOpenURL(String browserName) {
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		 
		return driver;
		
		
	}
	
	
	
	
	
	
}
