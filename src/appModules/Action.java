package appModules;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import pageObjects.Page;

import utility.Constants;
import utility.ExcelUtility;
import utility.PlugInFunctions;

public class Action {
	
	@SuppressWarnings("deprecation")
public static void create_process(WebDriver driver, ExtentReports report) throws Exception {
		
		String sUserName = ExcelUtility.getCellValue(1, Constants.Col_UserName);
		String sPassword = ExcelUtility.getCellValue(1, Constants.Col_Password);
		String search = ExcelUtility.getCellValue(1, Constants.Col_search);

		
		ExtentTest logger = report.startTest("creating task");
		
	
		//cancle button
		
		
		Page.btn_cancel(driver).click();
		logger.log(LogStatus.INFO, "clicked on btn_cancel");
		
		report.flush();
		

		//username
		Page.txtbx_UserName(driver).sendKeys(sUserName);
		logger.log(LogStatus.INFO, "Entered the UserName Successfully");
		report.flush();
		
			//password
		WebElement ele=Page.txtbx_Password(driver);
		ele.clear();
		ele.sendKeys(sPassword);
		
		
		
		
		System.out.println("enter key");
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("enter key after");
		/*Page.btn_LogIn2(driver).click();
		logger.log(LogStatus.INFO, "Clicked on the log-on b[utton Successfully");
		report.flush();*/
		
		
		//search
			Page.txtbx_search(driver).sendKeys("process");
			logger.log(LogStatus.INFO, "Entered the 'process' Successfully");
			System.out.println("search");
			
			//button go
			Page.btn_go(driver).click();
			logger.log(LogStatus.INFO, "Clicked on the go button Successfully");
			report.flush();
			
			//link overview
			Page.link_overview(driver).click();
			logger.log(LogStatus.INFO, "Clicked on link_overview");
			report.flush();
			
			//tab_purchase_order
			Thread.sleep(3000);
		
	driver.findElement(By.xpath("//*[@id='CEPJICNK.RRVCompView.ComponentTable:2147483641']")).sendKeys("invoice");
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("enter key after");
	
	Page.tab_purchase_order(driver).click();
			logger.log(LogStatus.INFO, "Clicked on tab_purchase_order");
			report.flush();
			
			//tab_process_defi
			Page.tab_process_defi(driver).click();
			logger.log(LogStatus.INFO, "Clicked on tab_process_defi");
			report.flush();
			
			//switching window
			String parent=driver.getWindowHandle();
			System.out.println("parent id= "+parent);
			Page.btn_start_process(driver).click();
			logger.log(LogStatus.INFO, "Clicked on btn_start_process");
			report.flush();
			
			

			Thread.sleep(5000);
		    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		
		System.out.println(driver.getTitle());
		
		String poid = ExcelUtility.getCellValue(1, Constants.Col_poid);
		String vendor = ExcelUtility.getCellValue(1, Constants.Col_vendor);
		String reqtr = ExcelUtility.getCellValue(1, Constants.Col_reqtr);
		String req_id = ExcelUtility.getCellValue(1, Constants.Col_req_id);
		
		
		//po id textbox
		    Page.txtbx_poid(driver).sendKeys(poid);
			logger.log(LogStatus.INFO, "entered txtbx_poid");
			report.flush();
		//vendor textbox	
			Page.txtbx_vendor(driver).sendKeys(vendor);
			logger.log(LogStatus.INFO, "entered txtbx_vendor");
			report.flush();
		//requester textbox	
			Page.txtbx_reqtr(driver).sendKeys(reqtr);
			logger.log(LogStatus.INFO, "entered txtbx_reqtr");
			report.flush();
		//request id textbox	
			Page.txtbx_reqID(driver).sendKeys(req_id);
			logger.log(LogStatus.INFO, "entered txtbx_reqID");
			report.flush();
			//button start process
			Page.btn_startpro(driver).click();
			logger.log(LogStatus.INFO, "Clicked on start process");
			report.flush();
			
		report.endTest(logger);
	
	}
	
public static void Approve_task(WebDriver driver, ExtentReports report) throws Exception {
		
		String sUserName = ExcelUtility.getCellValue(2, Constants.Col_UserName);
		String sPassword = ExcelUtility.getCellValue(2, Constants.Col_Password);
		String poid = ExcelUtility.getCellValue(1, Constants.Col_vendor);

		
		ExtentTest logger = report.startTest("approve task ");
		
		
		try{
		Page.txtbx_UserName(driver).sendKeys(sUserName);
		logger.log(LogStatus.INFO, "Entered the UserName Successfully");
		report.flush();}
		catch(Exception e){
		report.flush();}
	
		Page.txtbx_Password(driver).sendKeys(sPassword);
		
		
		logger.log(LogStatus.INFO, "Entered the Password Successfully");
		report.flush();
		
		
	
		Page.btn_LogIn2(driver).click();
		logger.log(LogStatus.INFO, "Clicked on the log-on button Successfully");
		report.flush();
		
		Thread.sleep(5000);
		Page.search_txtbx(driver).sendKeys(poid);
		
		Robot rob=new Robot();
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		logger.log(LogStatus.INFO, "entered poid in search");
		report.flush();
		Thread.sleep(2000);
			String parent=driver.getWindowHandle();
			System.out.println("parent id = "+parent);
			
	   Page.link_1st(driver).click();
	   logger.log(LogStatus.INFO, "clicked on link");
		report.flush();
	   
	   Set<String> handles=driver.getWindowHandles();
	    System.out.println(handles.size());
		Iterator<String> it=handles.iterator();
		while(it.hasNext())
		{
		String childID=it.next();
		System.out.println("child id = "+childID);
		System.out.println("condi="+childID.equals(parent));
		
	    driver.switchTo().window(childID);
	    Thread.sleep(3000);
	    
		
		}
	    
		/*Page.drp_dn_arrow(driver).click();
		logger.log(LogStatus.INFO, "clicked on drop down ");
		report.flush();
		Page.drp_dn_option(driver).click();
		logger.log(LogStatus.INFO, "clicked on dropdown option");
		report.flush();*/
		//Thread.sleep(5000);
		Thread.sleep(3000);
		Actions a2=new Actions(driver);
		a2.moveToElement(Page.approve_btn(driver)).click().perform();
//		Page.reject_btn(driver).click();
		logger.log(LogStatus.INFO, "clicked on reject btn");
		report.flush();
		//Thread.sleep(3000);
		Actions a1=new Actions(driver);
		a1.moveToElement(Page.pop_ok(driver)).click().perform();
		//Thread.sleep(4000);
		//Page.pop_ok(driver).click();
		logger.log(LogStatus.INFO, "clicked on ok btn");
		report.flush();
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//*[@id='oInbox--refreshButton']")).click();
		Thread.sleep(2000);
		System.out.println("if condi of approval task==="+Page.link_1st(driver).getText());
		if(Page.link_1st(driver).getText().equalsIgnoreCase("Approval for Invoice "+poid)==true)
		{
			System.out.println("inside if");
			String parent1=driver.getWindowHandle();
			System.out.println("parent id = "+parent1);
			Page.link_1st(driver).click();
			   logger.log(LogStatus.INFO, "clicked on link");
				report.flush();
			   
			   Set<String> handles1=driver.getWindowHandles();
			    System.out.println(handles1.size());
				Iterator<String> it1=handles1.iterator();
				while(it1.hasNext())
				{
				String childID=it1.next();
				System.out.println("child id = "+childID);
				System.out.println("condi="+childID.equals(parent1));
				
			    driver.switchTo().window(childID);
			    Thread.sleep(3000);
			    
				
				}
			    
				/*Page.drp_dn_arrow(driver).click();
				logger.log(LogStatus.INFO, "clicked on drop down ");
				report.flush();
				Page.drp_dn_option(driver).click();
				logger.log(LogStatus.INFO, "clicked on dropdown option");
				report.flush();*/
				//Thread.sleep(5000);
				Thread.sleep(3000);
				Actions a3=new Actions(driver);
				a2.moveToElement(Page.approve_btn(driver)).click().perform();
//				Page.reject_btn(driver).click();
				logger.log(LogStatus.INFO, "clicked on reject btn");
				report.flush();
				//Thread.sleep(3000);
				Actions a4=new Actions(driver);
				a1.moveToElement(Page.pop_ok(driver)).click().perform();
				//Thread.sleep(4000);
				//Page.pop_ok(driver).click();
				logger.log(LogStatus.INFO, "clicked on ok btn");
				report.flush();
				Thread.sleep(4000);
				driver.close();
				driver.switchTo().window(parent);
			
		}
		
		System.out.println("outside if");
		Page.btn_logout(driver).click();
		logger.log(LogStatus.INFO, "clicked on logout ");
		report.flush();
		
	}


	

public static void review_task(WebDriver driver, ExtentReports report) throws Exception {
	
	String sUserName = ExcelUtility.getCellValue(3, Constants.Col_UserName);
	String sPassword = ExcelUtility.getCellValue(3, Constants.Col_Password);
	String poid = ExcelUtility.getCellValue(1, Constants.Col_vendor);

	
	ExtentTest logger = report.startTest("review task");

	try{
	Page.txtbx_UserName(driver).sendKeys(sUserName);
	logger.log(LogStatus.INFO, "Entered the UserName Successfully");
	report.flush();}
	catch(Exception e){
	report.flush();}

		
	Page.txtbx_Password(driver).sendKeys(sPassword);
	logger.log(LogStatus.INFO, "Entered the Password Successfully");
	report.flush();

	Page.btn_LogIn2(driver).click();
	logger.log(LogStatus.INFO, "Clicked on the log-on button Successfully");
	report.flush();

	Thread.sleep(5000);
	Page.search_txtbx(driver).sendKeys(poid);
	Robot rob=new Robot();
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	logger.log(LogStatus.INFO, "entered poid");
	report.flush();
	
	Thread.sleep(2000);
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
   Page.link_1st(driver).click();
   logger.log(LogStatus.INFO, "clicked on link");
	report.flush();
   
   Set<String> handles=driver.getWindowHandles();
    System.out.println(handles.size());
	Iterator<String> it=handles.iterator();
	while(it.hasNext())
	{
	String childID=it.next();
	System.out.println(childID);
	System.out.println("condi="+childID.equals(parent));
	
    driver.switchTo().window(childID);
    Thread.sleep(2000);
	
	}
	Thread.sleep(3000);
	Actions a2=new Actions(driver);
	a2.moveToElement(Page.approve_btn(driver)).click().perform();
//	Page.reject_btn(driver).click();
	logger.log(LogStatus.INFO, "clicked on reject btn");
	report.flush();
	//Thread.sleep(3000);
	Actions a1=new Actions(driver);
	a1.moveToElement(Page.pop_ok(driver)).click().perform();
	logger.log(LogStatus.INFO, "clicked ok btn");
	report.flush();
	Thread.sleep(3000);
	driver.close();
	driver.switchTo().window(parent);
	driver.findElement(By.xpath("//*[@id='oInbox--refreshButton']")).click();
	Thread.sleep(2000);
	System.out.println("if condi of review task==="+Page.link_1st(driver).getText());
	if(Page.link_1st(driver).getText().equalsIgnoreCase("Review for Invoice"+poid)==true)
	{
		System.out.println("inside if");
		String parent1=driver.getWindowHandle();
		System.out.println("parent id = "+parent1);
		Page.link_1st(driver).click();
		   logger.log(LogStatus.INFO, "clicked on link");
			report.flush();
		   
		   Set<String> handles1=driver.getWindowHandles();
		    System.out.println(handles1.size());
			Iterator<String> it1=handles1.iterator();
			while(it1.hasNext())
			{
			String childID=it1.next();
			System.out.println("child id = "+childID);
			System.out.println("condi="+childID.equals(parent1));
			
		    driver.switchTo().window(childID);
		    Thread.sleep(3000);
		    
			
			}
		    
			/*Page.drp_dn_arrow(driver).click();
			logger.log(LogStatus.INFO, "clicked on drop down ");
			report.flush();
			Page.drp_dn_option(driver).click();
			logger.log(LogStatus.INFO, "clicked on dropdown option");
			report.flush();*/
			//Thread.sleep(5000);
			Thread.sleep(3000);
			Actions a3=new Actions(driver);
			a2.moveToElement(Page.approve_btn(driver)).click().perform();
//			Page.reject_btn(driver).click();
			logger.log(LogStatus.INFO, "clicked on reject btn");
			report.flush();
			//Thread.sleep(3000);
			Actions a4=new Actions(driver);
			a1.moveToElement(Page.pop_ok(driver)).click().perform();
			//Thread.sleep(4000);
			//Page.pop_ok(driver).click();
			logger.log(LogStatus.INFO, "clicked on ok btn");
			report.flush();
			Thread.sleep(4000);
			driver.close();
			driver.switchTo().window(parent);
		
	}
	
	System.out.println("outside if");
	Page.btn_logout(driver).click();
	logger.log(LogStatus.INFO, "clicked on logout ");
	report.flush();
}
	
public static void rejection_task(WebDriver driver, ExtentReports report) throws Exception {
	
	String sUserName = ExcelUtility.getCellValue(2, Constants.Col_UserName);
	String sPassword = ExcelUtility.getCellValue(2, Constants.Col_Password);
	String poid = ExcelUtility.getCellValue(1, Constants.Col_vendor);

	
	ExtentTest logger = report.startTest("reject task ");
	
	
	try{
	Page.txtbx_UserName(driver).sendKeys(sUserName);
	logger.log(LogStatus.INFO, "Entered the UserName Successfully");
	report.flush();}
	catch(Exception e){
	report.flush();}

	Page.txtbx_Password(driver).sendKeys(sPassword);
	
	
	logger.log(LogStatus.INFO, "Entered the Password Successfully");
	report.flush();
	
	

	Page.btn_LogIn2(driver).click();
	logger.log(LogStatus.INFO, "Clicked on the log-on button Successfully");
	report.flush();
	
	Thread.sleep(5000);
	Page.search_txtbx(driver).sendKeys(poid);
	
	Robot rob=new Robot();
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	
	logger.log(LogStatus.INFO, "entered poid in search");
	report.flush();
	Thread.sleep(2000);
		String parent=driver.getWindowHandle();
		System.out.println("parent id = "+parent);
		
   Page.link_1st(driver).click();
   logger.log(LogStatus.INFO, "clicked on link");
	report.flush();
   
   Set<String> handles=driver.getWindowHandles();
    System.out.println(handles.size());
	Iterator<String> it=handles.iterator();
	while(it.hasNext())
	{
	String childID=it.next();
	System.out.println("child id = "+childID);
	System.out.println("condi="+childID.equals(parent));
	
    driver.switchTo().window(childID);
    Thread.sleep(3000);
    
	
	}
	Thread.sleep(3000);
	Actions a2=new Actions(driver);
	a2.moveToElement(Page.reject_btn(driver)).click().perform();
//	Page.reject_btn(driver).click();
	logger.log(LogStatus.INFO, "clicked on reject btn");
	report.flush();
	//Thread.sleep(3000);
	Actions a1=new Actions(driver);
	a1.moveToElement(Page.pop_ok(driver)).click().perform();
	//Page.pop_ok(driver).click();
	logger.log(LogStatus.INFO, "clicked on ok btn");
	report.flush();
	Thread.sleep(4000);
	driver.close();
	driver.switchTo().window(parent);
	driver.findElement(By.xpath("//*[@id='oInbox--refreshButton']")).click();
	Thread.sleep(2000);
	System.out.println("if condi of rejection task==="+Page.link_1st(driver).getText());
	if(Page.link_1st(driver).getText().equalsIgnoreCase("Approval for Invoice "+poid)==true)
	{
		System.out.println("inside if");
		String parent1=driver.getWindowHandle();
		System.out.println("parent id = "+parent1);
		Page.link_1st(driver).click();
		   logger.log(LogStatus.INFO, "clicked on link");
			report.flush();
		   
		   Set<String> handles1=driver.getWindowHandles();
		    System.out.println(handles1.size());
			Iterator<String> it1=handles1.iterator();
			while(it1.hasNext())
			{
			String childID=it1.next();
			System.out.println("child id = "+childID);
			System.out.println("condi="+childID.equals(parent1));
			
		    driver.switchTo().window(childID);
		    Thread.sleep(3000);
		    
			
			}
		    
			/*Page.drp_dn_arrow(driver).click();
			logger.log(LogStatus.INFO, "clicked on drop down ");
			report.flush();
			Page.drp_dn_option(driver).click();
			logger.log(LogStatus.INFO, "clicked on dropdown option");
			report.flush();*/
			//Thread.sleep(5000);
			Thread.sleep(3000);
			Actions a3=new Actions(driver);
			a2.moveToElement(Page.reject_btn(driver)).click().perform();
//			Page.reject_btn(driver).click();
			logger.log(LogStatus.INFO, "clicked on reject btn");
			report.flush();
			//Thread.sleep(3000);
			Actions a4=new Actions(driver);
			a1.moveToElement(Page.pop_ok(driver)).click().perform();
			//Thread.sleep(4000);
			//Page.pop_ok(driver).click();
			logger.log(LogStatus.INFO, "clicked on ok btn");
			report.flush();
			Thread.sleep(4000);
			driver.close();
			driver.switchTo().window(parent);
		
	}
	
	System.out.println("outside if");
	Page.btn_logout(driver).click();
	logger.log(LogStatus.INFO, "clicked on logout ");
	report.flush();

	
	
}


public static void rework_task(WebDriver driver, ExtentReports report) throws Exception {
	String sUserName = ExcelUtility.getCellValue(4, Constants.Col_UserName);
	String sPassword = ExcelUtility.getCellValue(4, Constants.Col_Password);
	String poid = ExcelUtility.getCellValue(1, Constants.Col_vendor);

	
	ExtentTest logger = report.startTest("rework task");
	
	
	try{
	Page.txtbx_UserName(driver).sendKeys(sUserName);
	logger.log(LogStatus.INFO, "Entered the UserName Successfully");
	report.flush();}
	catch(Exception e){
	report.flush();}

	Page.txtbx_Password(driver).sendKeys("abc");
	logger.log(LogStatus.INFO, "Entered the Password Successfully");
	report.flush();
	
	

	Page.btn_LogIn2(driver).click();
	logger.log(LogStatus.INFO, "Clicked on the log-on button Successfully");
	report.flush();
	
	String str=Page.message(driver).getText();
	System.out.println(str);
	logger.log(LogStatus.ERROR, str);
	Boolean results = false;
	PlugInFunctions.errorHandling(driver, results, logger, "Login error");
	report.flush();
	

		Page.txtbx_Password(driver).sendKeys(sPassword);
		logger.log(LogStatus.INFO, "Entered the Password Successfully");
		report.flush();
		
		

		Page.btn_LogIn2(driver).click();
		logger.log(LogStatus.INFO, "Clicked on the log-on button Successfully");
		report.flush();
	
	
	
	Thread.sleep(5000);
	Page.search_txtbx(driver).sendKeys(poid);
	Robot rob=new Robot();
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	logger.log(LogStatus.INFO, "Entered poid");
	report.flush();
	
	Thread.sleep(2000);
		String parent=driver.getWindowHandle();
		System.out.println("parent id = "+parent);
		
   Page.link_1st(driver).click();
   logger.log(LogStatus.INFO, "clicked on link");
	report.flush();
   
   Set<String> handles=driver.getWindowHandles();
    System.out.println(handles.size());
	Iterator<String> it=handles.iterator();
	while(it.hasNext())
	{
	String childID=it.next();
	System.out.println("child id = "+childID);
	System.out.println("condi="+childID.equals(parent));
	
    driver.switchTo().window(childID);
    Thread.sleep(3000);
	
	}
	Thread.sleep(3000);
	//Page.approve_btn(driver).click();
	Actions a1=new Actions(driver);
	a1.moveToElement(Page.approve_btn(driver)).click().perform(); 
	logger.log(LogStatus.INFO, "clicked on approve btn");
		report.flush();
	//	Thread.sleep(3000);
	//Page.pop_ok(driver).click();
	Actions a2=new Actions(driver);
	a2.moveToElement(Page.pop_ok(driver)).click().perform(); 
	 logger.log(LogStatus.INFO, "clicked on ok btn");
		report.flush();
	Thread.sleep(4000);
	driver.close();
	driver.switchTo().window(parent);
	driver.findElement(By.xpath("//*[@id='oInbox--refreshButton']")).click();
	Thread.sleep(2000);
	System.out.println("if condi of rework task==="+Page.link_1st(driver).getText());
	if(Page.link_1st(driver).getText().equalsIgnoreCase("Rework for Invoice"+poid)==true)
	{
		System.out.println("inside if");
		String parent1=driver.getWindowHandle();
		System.out.println("parent id = "+parent1);
		Page.link_1st(driver).click();
		   logger.log(LogStatus.INFO, "clicked on link");
			report.flush();
		   
		   Set<String> handles1=driver.getWindowHandles();
		    System.out.println(handles1.size());
			Iterator<String> it1=handles1.iterator();
			while(it1.hasNext())
			{
			String childID=it1.next();
			System.out.println("child id = "+childID);
			System.out.println("condi="+childID.equals(parent1));
			
		    driver.switchTo().window(childID);
		    Thread.sleep(3000);
		    
			
			}
		    
			/*Page.drp_dn_arrow(driver).click();
			logger.log(LogStatus.INFO, "clicked on drop down ");
			report.flush();
			Page.drp_dn_option(driver).click();
			logger.log(LogStatus.INFO, "clicked on dropdown option");
			report.flush();*/
			//Thread.sleep(5000);
			Thread.sleep(3000);
			Actions a3=new Actions(driver);
			a2.moveToElement(Page.approve_btn(driver)).click().perform();
//			Page.reject_btn(driver).click();
			logger.log(LogStatus.INFO, "clicked on reject btn");
			report.flush();
			//Thread.sleep(3000);
			Actions a4=new Actions(driver);
			a1.moveToElement(Page.pop_ok(driver)).click().perform();
			//Thread.sleep(4000);
			//Page.pop_ok(driver).click();
			logger.log(LogStatus.INFO, "clicked on ok btn");
			report.flush();
			Thread.sleep(4000);
			driver.close();
			driver.switchTo().window(parent);
		
	}
	
	System.out.println("outside if");
	Page.btn_logout(driver).click();
	logger.log(LogStatus.INFO, "clicked on logout ");
	report.flush();
	
	
}

public static void check_process(WebDriver driver, ExtentReports report) throws Exception {
	
	String sUserName = ExcelUtility.getCellValue(1, Constants.Col_UserName);
	String sPassword = ExcelUtility.getCellValue(1, Constants.Col_Password);
	
	String poid = ExcelUtility.getCellValue(1, Constants.Col_vendor);
	
	ExtentTest logger = report.startTest("creating task");
	

	//cancle button
	
	
	Page.btn_cancel(driver).click();
	logger.log(LogStatus.INFO, "clicked on btn_cancel");
	
	report.flush();
	

	//username
	Page.txtbx_UserName(driver).sendKeys(sUserName);
	logger.log(LogStatus.INFO, "Entered the UserName Successfully");
	report.flush();
	
		//password
	WebElement ele=Page.txtbx_Password(driver);
	ele.clear();
	ele.sendKeys(sPassword);
	
	
	
	
	System.out.println("enter key");
	Robot rob=new Robot();
	rob.keyPress(KeyEvent.VK_ENTER);
	rob.keyRelease(KeyEvent.VK_ENTER);
	System.out.println("enter key after");
	/*Page.btn_LogIn2(driver).click();
	logger.log(LogStatus.INFO, "Clicked on the log-on b[utton Successfully");
	report.flush();*/
	
	Thread.sleep(2000);
	//search
		Page.txtbx_search(driver).sendKeys("manage");
		logger.log(LogStatus.INFO, "Entered the 'process' Successfully");
		System.out.println("search");
		Thread.sleep(2000);
		//button go
		Page.btn_go(driver).click();
		logger.log(LogStatus.INFO, "Clicked on the go button Successfully");
		report.flush();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='CEPJFMAJ.WorkCenterOverviewView._71']/tbody/tr/td")).click();
		logger.log(LogStatus.INFO, "Clicked on process instances Successfully");
		report.flush();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='Advanced']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='CEPJICNK.ProcMgmtView.InstanceAdvancedQueryStatusDDBK-btn']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='SVSDK.com.sap.tc.bpem.nwa.processmgmt.procmgmt.data.ProcessLifeCycle-key-4']/td[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='CEPJICNK.ProcMgmtView.InstanceAdvancedQueryGoButton']/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='CEPJICNK.ProcMgmtView.ProcessInstanceTable:2147483639']")).sendKeys(poid);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		String str=driver.findElement(By.xpath("//*[@id='CEPJICNK.ProcMgmtView.ProcessInstanceTable-contentTBody']/tr[3]/td[3]")).getText();
	logger.log(LogStatus.INFO, "status:"+str);
	
	report.flush();
	

	

}
	
}
