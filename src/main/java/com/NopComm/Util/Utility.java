package com.NopComm.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//Excel read write screenshot properties file

public class Utility
{
	FileInputStream file;
	static Workbook wbf;
	
	public static String excelStringData(String sheetname, int rowindex, int cellindex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Java_Project\\ZMavenNopCommerce\\Testdata\\DataDriven.xlsx");
		wbf = WorkbookFactory.create(file);
		
		return wbf.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getStringCellValue();
	}
	
	public static boolean excelBooleanData(String sheetname, int rowindex, int cellindex)
	{
		return wbf.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getBooleanCellValue();
	}
	
	public static double excelNumericData(String sheetname, int rowindex, int cellindex)
	{
		return wbf.getSheet(sheetname).getRow(rowindex).getCell(cellindex).getNumericCellValue();
	}
	
	public static void screenshot(WebDriver driver) throws InterruptedException, IOException
	{
		File src = (File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		String time = d.toString().replace(":", "_").replace(" ", "_");
	
		File dest = new File("C:\\Java_Project\\ZMavenNopCommerce\\Screenshot\\Maven\\Img."+time+".jpg");
		Thread.sleep(5000);
		
		FileHandler.copy(src, dest);
	}
}