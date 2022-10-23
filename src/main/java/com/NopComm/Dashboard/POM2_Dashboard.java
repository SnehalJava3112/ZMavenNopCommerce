package com.NopComm.Dashboard;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.NopComm.Util.Utility;

public class POM2_Dashboard 
{
	@FindBy (xpath = "//img[@class='brand-image-xl logo-xl']") private WebElement logo;

// Logo display
	
	public POM2_Dashboard(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void logoValidation(WebDriver driver) throws InterruptedException, IOException
	{
		boolean actLogoResult = Utility.excelBooleanData("Sheet1", 1, 4);		
		boolean expLogoResult = logo.isDisplayed();
		
		Assert.assertEquals(actLogoResult, expLogoResult, "Logo -> not Displayed");
		
		Utility.screenshot(driver);
	}
	
	
}
