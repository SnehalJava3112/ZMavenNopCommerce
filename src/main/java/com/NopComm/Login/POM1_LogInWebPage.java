package com.NopComm.Login;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NopComm.Util.Utility;

public class POM1_LogInWebPage
{
	@FindBy (xpath = "//input[@id='RememberMe']") private WebElement chkBox;
	@FindBy (xpath = "//input[@id='Email']") private WebElement email;
	@FindBy (xpath = "//input[@id='Password']") private WebElement pwd;
	@FindBy (xpath = "//button[@type='submit']") private WebElement submit;
	
	public POM1_LogInWebPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
// title
		
		@Test
		public void titleValidation(WebDriver driver) throws EncryptedDocumentException, IOException
		{
			String actTitle = Utility.excelStringData("Sheet1", 1, 0); 		//"Your store. Login";
			String expeTitle = driver.getTitle(); //= "Your store. Login";
			System.out.println(expeTitle);
			Assert.assertEquals(expeTitle, actTitle, "Title texts -> different");
			
//			if(actTitle.equals(expeTitle))
//				System.out.println("Title -> Passed");
//			else
//				System.out.println("Title -> Failed");
		}

// checkbox -> default non selected
		@Test
		public void chkBoxValidation()
		{
			boolean actChkResult = Utility.excelBooleanData("Sheet1", 1, 1);
			boolean expChkResult = chkBox.isSelected();
			Assert.assertEquals(actChkResult, expChkResult, "Default checkbox -> selected");
			
//			if(actChkResult == expChkResult)
//				System.out.println("Default checkbox -> Not selected");
//			else
//				System.out.println("Default checkbox -> Selected");
		}

// Enter Email
		@Test
		public void emailValidation() throws EncryptedDocumentException, IOException
		{
			email.clear();
			email.sendKeys(Utility.excelStringData("Sheet1", 1, 2));   
		}
	
// Enter Password
		@Test
		public void pwdValidation() throws EncryptedDocumentException, IOException
		{
			pwd.clear();
			pwd.sendKeys(Utility.excelStringData("Sheet1", 1, 3));    
		}
		
// login button
		@Test
		public void submitValidation()
		{
			submit.click();
		}
}