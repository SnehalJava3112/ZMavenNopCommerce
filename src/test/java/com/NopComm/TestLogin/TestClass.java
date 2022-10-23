package com.NopComm.TestLogin;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.NopComm.Base.BaseClass;
import com.NopComm.Dashboard.POM2_Dashboard;
import com.NopComm.Login.POM1_LogInWebPage;

public class TestClass extends BaseClass
{	
	POM1_LogInWebPage p1;
	POM2_Dashboard p2;
	
	@BeforeClass
	public void browserOpening() throws EncryptedDocumentException, InterruptedException, IOException
	{
		broserLaunch();
		p2 = new POM2_Dashboard(driver);
		p1 = new POM1_LogInWebPage(driver);
	}
	
	@Test(priority = 1)
	public void titleVerify() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		
		p1.titleValidation(driver);		Thread.sleep(2000);
	}	
	@Test(priority = 2)
	public void chkBoxVerify() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		p1.chkBoxValidation();			Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void loginVerify() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		p1.emailValidation();		Thread.sleep(2000);
		p1.pwdValidation();			Thread.sleep(2000);
		p1.submitValidation();		Thread.sleep(2000);
	}
	
	@Test(dependsOnMethods = "loginVerify")
	public void logoVerify() throws EncryptedDocumentException, InterruptedException, IOException 
	{
		p2.logoValidation(driver);
	}
	
	@AfterClass
	public void closingBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
}