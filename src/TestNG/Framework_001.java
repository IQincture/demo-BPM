package TestNG;

import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import appModules.Action;
import appModules.PiActions;
import pageObjects.Page;
import utility.Constants;
import utility.ExcelUtility;
import utility.FileMerger;
import utility.LaunchBrowser;
import utility.PlugInFunctions;

public class Framework_001 {

	private WebDriver driver;
	public static ExtentReports report = PlugInFunctions.reportGeneration();
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		//Sign in to cwd
		driver = LaunchBrowser.execute(driver, report); 
	}

	@Test
	public void main() throws Exception {

		boolean flag=true;
		
		try{
		//Setting the excel file and sheet
		ExcelUtility.setExcel(Constants.xcelPath + Constants.xcelfile, "Sheet1");
		//Creating process
		Action.create_process(driver, report);
		//Sign in to BPMinbox
		Thread.sleep(5000);
		driver = LaunchBrowser.execute2(driver, report); 
		//Approving task
	  Action.Approve_task(driver, report);
	    //Reviewing task
		Action.review_task(driver, report);
		//login to pi
		Thread.sleep(5000);
		driver = LaunchBrowser.execute(driver, report);
		Action.check_process(driver, report);
		
		}
		catch(Exception e)
		{
			ExtentTest logger = report.startTest("failure");
			System.out.println("exception handled"+e);
			logger.log(LogStatus.FAIL, e);
			PlugInFunctions.errorHandling(driver, false, logger, "failure report");
			logger.log(LogStatus.ERROR, " <a href='https://google.com'> retest</a>" );
			report.flush();
			flag=false;
			
		}
		
		Assert.assertEquals(flag , true);
		
		

	}

	@AfterMethod
	public void afterMethod() {

		//PlugInFunctions.Mail(driver, report);

	}

}
