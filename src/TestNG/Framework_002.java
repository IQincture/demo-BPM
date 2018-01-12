package TestNG;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import appModules.Action;
import utility.Constants;
import utility.ExcelUtility;
import utility.LaunchBrowser;
import utility.PlugInFunctions;

public class Framework_002 {

	
	private WebDriver driver;
	public static ExtentReports report = PlugInFunctions.reportGeneration();
	
	@BeforeMethod
	public void beforeMethod() throws Exception {
		//FileMerger.mergeFiles();
		driver = LaunchBrowser.execute(driver, report); 
	}

	@Test
	public void main() {

		boolean flag=true;
		try{
		ExcelUtility.setExcel(Constants.xcelPath + Constants.xcelfile, "Sheet1");
		Action.create_process(driver, report);
		driver = LaunchBrowser.execute2(driver, report);
		Action.rejection_task(driver, report);
		Action.rework_task(driver, report);
		Action.Approve_task(driver, report);
		Action.review_task(driver, report);}
		catch(Exception e){
			ExtentTest logger = report.startTest("failure");
			System.out.println("exception handled"+e);
			logger.log(LogStatus.FAIL, e);
			PlugInFunctions.errorHandling(driver, false, logger, "failure report");
			report.flush();
			flag=false;
			
		}
		
		Assert.assertEquals(flag , true);
	}

	@AfterMethod
	public void afterMethod() {


	}
	
}
