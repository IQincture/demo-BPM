package pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mongodb.gridfs.CLI;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestNG.Framework_001;
import utility.PlugInFunctions;

public class Page extends Framework_001 {
	
	static FileInputStream file;
	static Properties prop;


	   private static WebElement element = null;
	   

	     
	public static WebElement txtbx_UserName(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txtbx_UserName"));
		//logger.log(LogStatus.INFO,"user name text box in page object");
		System.out.println("username");
		return element;
		
	    }

	public static WebElement txtbx_Password(WebDriver driver) throws Exception{
		
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txtbx_Password"));
		//logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("password");
		return element;
		
		
	    }

	public static WebElement btn_cancel(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_cancel"));
		System.out.println("btn_cancel");
		return element;
		    }

	public static WebElement btn_LogIn2(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_LogIn2"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("login button");
		return element;
		      }

	public static WebElement txtbx_search(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txtbx_search"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("txtbx_search");
		return element;
		      }

	public static WebElement btn_go(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_go"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("btn_go");
		return element;
		      }

	public static WebElement link_overview(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("link_overview"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("link_overview");
		return element;
		      }

	public static WebElement tab_purchase_order(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("tab_purchase_order"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("tab_purchase_order");
		return element;
		      }

	public static WebElement tab_process_defi(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("tab_process_defi"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("tab_process_defi");
		return element;
		      }

	public static WebElement btn_start_process(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_start_process"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("btn_start_process");
		return element;
		      }

	public static WebElement txtbx_poid(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txtbx_poid"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("txtbx_poid");
		return element;
		      }

	public static WebElement txtbx_vendor(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txtbx_vendor"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("txtbx_vendor");
		return element;
		      }

	public static WebElement txtbx_reqtr(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txtbx_reqtr"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("txtbx_reqtr");
		return element;
		      }

		
	public static WebElement txtbx_reqID(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("txtbx_reqID"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("txtbx_reqID");
		return element;
		      }

	public static WebElement btn_startpro(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_startpro"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("btn_startpro");
		return element;
		      }
	public static WebElement search_txtbx(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("search_txtbx"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("search_txtbx");
		return element;
		      }

	public static WebElement link_1st(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("link_1st"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("link_1st");
		return element;
		      }

	public static WebElement approve_btn(WebDriver driver) throws Exception{
		    		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("approve_btn"));
		    		////logger.log(LogStatus.INFO,"password of page object in login");
		    		System.out.println("approve_btn");
		    		return element;
		    		      }
	public static WebElement pop_ok(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("pop_ok"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("pop_ok");
		return element;
		      }	
	
	public static WebElement btn_logout(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("btn_logout"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("pop_ok");
		return element;
		      }
	
	public static WebElement reject_btn(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("reject_btn"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("reject_btn");
		return element;
		      }
	
	public static WebElement message(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("message"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("message");
		return element;
		      }
	
	public static WebElement drp_dn_arrow(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("drp_dn_arrow"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("drp_dn_arrow");
		return element;
		      }
	
	public static WebElement drp_dn_option(WebDriver driver) throws Exception{
		element = PlugInFunctions.expWait(driver, PlugInFunctions.loadXPathfile().getProperty("drp_dn_option"));
		////logger.log(LogStatus.INFO,"password of page object in login");
		System.out.println("drp_dn_option");
		return element;
		      }
}


