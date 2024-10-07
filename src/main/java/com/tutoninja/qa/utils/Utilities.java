package com.tutoninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
public static String generateEmail() {
		
		Date date=new Date();
		
		String timestamp=date.toString().replace(" ","_").replace(":","_");
		return "sham"+timestamp+"@gmail.com";
	}

public static Object [][] getDataFromXcel(String sheetName) {
	
	XSSFWorkbook workbook = null;
	File excelfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutoninja\\qa\\testdata\\TutoNinjaTestData.xlsx");

		try {
		FileInputStream fisExcel = new FileInputStream(excelfile);
		 workbook = new XSSFWorkbook(fisExcel);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 XSSFSheet sheet = workbook.getSheet(sheetName);
	int rows=sheet.getLastRowNum();
	int cols=sheet.getRow(0).getLastCellNum();
	
	Object [][] data= new Object [rows][cols];
	
	for(int i=0; i<rows;i++) {
		XSSFRow row =sheet.getRow(i+1);
		 
		for(int j=0; j<cols;j++) {
			XSSFCell cell =row.getCell(j);
			
			CellType cellType=cell.getCellType();
			
			switch(cellType) {
			
			case STRING:
				data[i][j]=cell.getStringCellValue();
				break;
				
			case NUMERIC:
				data[i][j]=Integer.toString((int)cell.getNumericCellValue());
				break;
				
			
			
			}
		
		}
		
	}
	return data ;
}


public static String Screenshot(WebDriver driver,  String textName) {
	
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	String destiPath=System.getProperty("user.dir")+"\\Screenshots\\"+textName+".png";
	
	try {
		FileHandler.copy(SrcFile,new File (destiPath));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return destiPath;
	
}

}

