package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class LaunchBrowser {

	//public static Properties propGet ;
	
	public static WebDriver execute(WebDriver driver, ExtentReports report) throws Exception{
		
		//ExtentReports report = new ExtentReports("E:\\Bin\\Selenium\\AutomationFramWork\\ExtendReports\\"+Constants.reportName+ ".html");
		//ExtentTest logger = report.startTest("Launch Browser");
		ExtentTest logger = report.startTest("Launch nwa ");
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
		logger.log(LogStatus.INFO, "Driver intiantiated");

		driver.get(Constants.URL);
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Maximize the browser and Open the application");
		
		
		report.endTest(logger);
		report.flush();
		
		return driver;
		
	}
	
public static WebDriver execute2(WebDriver driver, ExtentReports report) throws Exception{
		
		//ExtentReports report = new ExtentReports("E:\\Bin\\Selenium\\AutomationFramWork\\ExtendReports\\"+Constants.reportName+ ".html");
		//ExtentTest logger = report.startTest("Launch Browser");
		ExtentTest logger = report.startTest("Launch BPM inbox");
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		driver = new ChromeDriver();
		logger.log(LogStatus.INFO, "Driver intiantiated");

		driver.get(Constants.url2);
		driver.manage().window().maximize();
		logger.log(LogStatus.INFO, "Maximize the browser and Open the application");
		
		
		report.endTest(logger);
		report.flush();
		
		return driver;
		
	}



	public static WebDriver execute3(WebDriver driver, ExtentReports report) throws Exception{
	
	//ExtentReports report = new ExtentReports("E:\\Bin\\Selenium\\AutomationFramWork\\ExtendReports\\"+Constants.reportName+ ".html");
	//ExtentTest logger = report.startTest("Launch Browser");
	ExtentTest logger = report.startTest("Launch BPM inbox");
	
	System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
	driver = new ChromeDriver();
	logger.log(LogStatus.INFO, "Driver intiantiated");

	driver.get("http://incturecwd:50000/webdynpro/dispatcher/sap.com/tc~lm~itsam~ui~mainframe~wd/FloorPlanApp?applicationID=com.sap.itsam.mon.xi.msg&type=AdapterEngine#");
	driver.manage().window().maximize();
	logger.log(LogStatus.INFO, "Maximize the browser and Open the application");
	
	
	report.endTest(logger);
	report.flush();
	
	return driver;
	
}




}
