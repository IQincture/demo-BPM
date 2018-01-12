package appModules;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class PiActions {
	
	
	public static void monitor(WebDriver driver, ExtentReports report) throws Exception {
		
		//cancle button
		driver.findElement(By.xpath("//*[@id='tblInnerCnt']/tbody/tr/td[3]/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/form/table/tbody/tr[2]/td[1]/input[2]")).click();
		//username
		driver.findElement(By.xpath("//*[@id='logonuidfield']")).sendKeys("inc00207");
		//password
		driver.findElement(By.xpath("//*[@id='logonpassfield']")).sendKeys("Incture!234");
		//login button
		driver.findElement(By.xpath("//*[@id='logonForm']/table/tbody/tr[5]/td[2]/input")).click();
		
		
		// error column check
					if(driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[2]")).getText().equals("0")==false){
					
						String count=driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[2]")).getText();
						int error_count = Integer.parseInt(count);
						System.out.println("error_count="+error_count);
						
						driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.LinkActionERROR.0']")).click();
						Thread.sleep(2000);
						for(int i=0;i<=error_count;i++)
						{
							int j=0;
							System.out.println(driver.findElement(By.xpath("//*[@id='CEPJICNKPDIF.TableView.CaptionStatusField."+j+"']")).getAttribute("title"));
							j++;
						}
					}
					
					//Scheduled column check
					if(driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[3]")).getText().equals("0")==false){
						
						String count=driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[3]")).getText();
						int Scheduled_count = Integer.parseInt(count);
						System.out.println("Scheduled_count="+Scheduled_count);
						
						driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.LinkActionSCHEDULED.0']")).click();
						Thread.sleep(2000);
						for(int i=0;i<=Scheduled_count;i++)
						{
							int j=0;
							System.out.println(driver.findElement(By.xpath("//*[@id='CEPJICNKPDIF.TableView.CaptionStatusField."+j+"']")).getAttribute("title"));
							j++;
						}
					}
					
					//success column check
					else{if(driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[4]")).getText().equals("0")==false){
					System.out.println("-------------------done---------------------------");
					String count=driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[4]")).getText();
					int scount = Integer.parseInt(count);
					System.out.println("scount="+scount);
					
					driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.LinkActionSUCCESSFUL.0']")).click();
					//System.out.println(driver.findElement(By.xpath("//*[@id='CEPJICNK.MessageFilterView.FindStatusGroup']")).getText());
					
					Thread.sleep(2000);
					//clicked on Integration Scenario: button
					driver.findElement(By.xpath("//*[@id='CEPJICNK.MessageFilterView.ScenarioIDInputField']")).click();
					driver.findElement(By.xpath("//*[@id='CEPJICNK.MessageFilterView.ScenarioIDInputField-btn']")).click();
					Thread.sleep(2000);
					driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='URLSPW-0']")));
					//clicked on close button
					driver.findElement(By.xpath("//*[@id='CEPJICNK.ValueHelpWindow.Window-close']/img")).click();
					driver.switchTo().defaultContent();
					
					Thread.sleep(2000);
					for(int i=0;i<scount;i++)
					{
						int j=0;
						System.out.println(driver.findElement(By.xpath("//*[@id='CEPJICNKPDIF.TableView.CaptionStatusField."+j+"']")).getAttribute("title"));
						driver.findElement(By.xpath("//*[@id='CEPJICNKPDIF.TableView.CaptionStatusField."+j+"']")).click();
						String parent3=driver.getWindowHandle();
						System.out.println("parent id = "+parent3);
						
						
						Thread.sleep(2000);
						//click on open message
						Actions act=new Actions(driver);
						act.moveToElement(driver.findElement(By.xpath("//*[@id='CEPJICNKPDIF.TableView.ToolbarButtonPAYLOAD']"))).click().perform();
						System.out.println("clicked on open button");
						Thread.sleep(5000);
						
						Set<String> handles3=driver.getWindowHandles();
					    System.out.println(handles3.size());
						Iterator<String> it3=handles3.iterator();
						while(it3.hasNext())
						{
						String childID=it3.next();
						System.out.println("child id = "+childID);
						System.out.println("condi="+childID.equals(parent3));
						
					    driver.switchTo().window(childID);
					    Thread.sleep(3000);
						}
						Thread.sleep(3000);
						
						//click on payload
						driver.findElement(By.xpath("//*[@id='CEPJICNK.MsgPayloadDetail.PayloadTab-focus']")).click();
						Thread.sleep(3000);
						//click on download
						driver.findElement(By.xpath("//*[@id='CEPJICNK.MsgDetailView.PayloadFileDownload']")).click();
						driver.close();
						driver.switchTo().window(parent3);
						j++;
					}
					
					}
					//../../../../webdynpro/resources/sap.com/tc~lm~itsam~co~ui~xi~msg~wd/Components/com.sap.tc.lm.itsam.co.ui.xi.msg.ximessagedetailed.XIMessageDetailed/s_s_ledg.gif
					//../../../../webdynpro/resources/sap.com/tc~lm~itsam~co~ui~xi~msg~wd/Components/com.sap.tc.lm.itsam.co.ui.xi.msg.ximessagedetailed.XIMessageDetailed/s_s_ledg.gif
					
					//Terminated with error column check
					else{if(driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[5]")).getText().equals("0")==false){
						
						String count=driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.ALVTable-contentTBody']/tr[2]/td[5]")).getText();
						int Terminated_count = Integer.parseInt(count);
						System.out.println("Terminated_count="+Terminated_count);
						
						driver.findElement(By.xpath("//*[@id='CEPJICNKDKEC.TableView.LinkActionCANCEL.0']")).click();
						Thread.sleep(2000);
						for(int i=0;i<=Terminated_count;i++)
						{
							int j=0;
							System.out.println(driver.findElement(By.xpath("//*[@id='CEPJICNKPDIF.TableView.CaptionStatusField."+j+"']")).getAttribute("title"));
							j++;
						}
					}
					}}
					
		
		
		
		
	}
	

}
