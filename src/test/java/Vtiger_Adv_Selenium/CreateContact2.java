package Vtiger_Adv_Selenium;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import Components.ExcelUtils;
import Components.FileUtils1;
import Components.WebDriverUtils;

public class CreateContact2 {

	@Test 
	
	public void login() throws IOException, InterruptedException { 

		 WebDriver d = null;
		 FileUtils1 futils = new FileUtils1();
		 WebDriverUtils wutils = new WebDriverUtils();
		 ExcelUtils eutils = new ExcelUtils();
		 
		 
		 
		String BROWSER= futils.getDataFromPropertyFile("Browser");
		String URL = futils.getDataFromPropertyFile("Url");
		//String FNAME =  futils.getDataFromPropertyFile("FirstName");
		//String Lname =  futils.getDataFromPropertyFile("LastName");
		String ASSIGNED = futils.getDataFromPropertyFile("Assigned");
		
		
		String First = eutils.getDataFromExcelSheet("Sheet1",2,1); //rownum
		String Last = eutils.getDataFromExcelSheet("Sheet1",3,1);
		  
		 if(BROWSER.equalsIgnoreCase("Chrome"))
			{ 
				d = new ChromeDriver();
			}
			else if (BROWSER.equalsIgnoreCase("FireFox")) 
			{	
				d = new FirefoxDriver();  
			} 
			else if (BROWSER.equalsIgnoreCase("Edge"))
			{  
				d = new EdgeDriver(); 
			}
		 
		 //maximize window
		 wutils.maximize(d);
		 
		 //implicit wait for url
		 wutils.implicitWait(d);
		 
		 //launching url
		 d.get(URL);
		 Thread.sleep(2000);
		//finding username to login page
		WebElement uname = d.findElement(By.name("username"));
		//clearing textfield
		uname.clear();
		Thread.sleep(2000);
		//giving username manually
		uname.sendKeys("admin");
		Thread.sleep(2000);
		//finding password to login page
		WebElement pw = d.findElement(By.name("password"));
		//clearing textfield
		pw.clear();
		Thread.sleep(2000);
		//giving password manually
		pw.sendKeys("admin");
		Thread.sleep(2000);
		//click on sign in button
		 d.findElement(By.xpath("//button[text()='Sign in']")).click();
		 Thread.sleep(2000);
		 //click on menu option
		d.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		 Thread.sleep(2000);
		 //click on marketing option
		d.findElement(By.xpath("//span[text()=' MARKETING']")).click();
		 Thread.sleep(2000);
		 //click on contacts
		 d.findElement(By.xpath("(//span[text()=' Contacts'])[1]")).click();
		Thread.sleep(2000);
		//click on add contacts button
		d.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		Thread.sleep(2000);
		//click on dropdown of title
		d.findElement(By.xpath("(//a[@class='select2-choice'])[1]")).click();
		Thread.sleep(2000);
		//click on search bar & giving value
		d.findElement(By.xpath("(//div[@class='select2-result-label'])[3]")).click();
		Thread.sleep(2000);
		//giving firstname input
		d.findElement(By.name("firstname")).sendKeys(First);
		Thread.sleep(2000);
		//giving lastname input 
		d.findElement(By.name("lastname")).sendKeys(Last);
		Thread.sleep(2000);

		//scrolling opeartion
		JavascriptExecutor jse = (JavascriptExecutor) d ;
		jse.executeScript("window.scrollBy(0,200)");  
		Thread.sleep(4000);
		
		//click on assign to dropdown
		d.findElement(By.xpath("(//span[@class='select2-arrow'])[3]")).click();
		//click on search box
		WebElement drop = d.findElement(By.id("s2id_autogen6_search"));
		//passing the value as input
		drop.sendKeys(ASSIGNED);
		Thread.sleep(2000);
		//selecting the value
		drop.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//click on save button
		d.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);		
		//click on signout option
		WebElement signout = d.findElement(By.xpath("//span[@class='fa fa-user']"));
		Thread.sleep(2000);
		//mousehovering on signout img
		wutils.movoTo(d, signout);
		Thread.sleep(2000);
		//click on signout option
		wutils.action(d, signout);
		Thread.sleep(2000);
		// click on signout button
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		
		
		
		 
		 
		 
		 
	}

}
