package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PMC {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://34.213.118.108:50000/app1/pmc/detailIndex.html");
		
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='logonuidfield']")).sendKeys("inc00695");
		driver.findElement(By.xpath("//*[@id='logonpassfield']")).sendKeys("Password@2");
		driver.findElement(By.xpath("//*[@id='logonForm']/table/tbody/tr[5]/td[2]/input")).click();
		
		creation(driver,"Purchase Order",2,30);

	}

	
public static void creation(WebDriver driver, String Process_Name, int No_of_task,int i) {
	
	
	
	
	for(int j=1;j<=No_of_task;j++){
		driver.findElement(By.xpath("//*[@id='iddetail--process-arrow']")).click();
	String str2=String.valueOf(i);
	String str="ABC"+i;
	System.out.println(str);
	driver.findElement(By.xpath("//*[text()='"+Process_Name+"']")).click();
	driver.findElement(By.xpath("//*[@id='__input0-inner']")).sendKeys(str);//*[@id="__input0-inner"]
	i++;
	
	driver.findElement(By.xpath("//*[@id='__input1-inner']")).sendKeys(str2);//*[@id="__input2-inner"]//*[@id="__input1-inner"]
	i++;
	String str3=String.valueOf(i);
	driver.findElement(By.xpath("//*[@id='__input2-inner']")).sendKeys(str3);//*[@id="__input5-inner"]
	i++;
	String str4=String.valueOf(i);
	driver.findElement(By.xpath("//*[@id='__input4-inner']")).sendKeys(str4);//*[@id="__input8-inner"]
	i++;
	String str5=String.valueOf(i);
	driver.findElement(By.xpath("//*[@id='__input7-inner']")).sendKeys(str5);//*[@id="__input10-inner"]
	i++;
	//*[@id="__input10-inner"]
	
	driver.findElement(By.xpath("//*[@id='__button3-content']/bdi")).click();
	System.out.println("task "+j+" created");
	
	}

	}
	
	
	
}
