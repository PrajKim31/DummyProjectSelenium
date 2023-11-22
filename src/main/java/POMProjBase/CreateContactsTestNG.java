package POMProjBase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtils.BaseClassCont;
import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils1;
import CommonUtils.WebDriverUtils;

public class CreateContactsTestNG extends BaseClassCont {
 

		//public WebDriver d;
		
		@Test 
		
		public void login() throws IOException, InterruptedException {
		
		 FileUtils1 futils = new FileUtils1();
		 WebDriverUtils wutils = new WebDriverUtils();
		 ExcelUtils eutils = new ExcelUtils();
		 
		 // read data from property file
		 String ASSIGNED = futils.getDataFromPropertyFile("Assigned");
		
		
		// read data from excel
		String First = eutils.getDataFromExcelSheet("Sheet1",2,1); //row & col
		String Last = eutils.getDataFromExcelSheet("Sheet1",3,1);
		  
		
		
		 //click on menu option
		d.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		 Thread.sleep(2000);
		 Reporter.log("Clicking on menu option");
		 //click on marketing option
		d.findElement(By.xpath("//span[text()=' MARKETING']")).click();
		 Thread.sleep(2000);
		 Reporter.log("Clicking on marketing option");
		 //click on contacts
		 d.findElement(By.xpath("(//span[text()=' Contacts'])[1]")).click();
		Thread.sleep(2000);
		Reporter.log("Click on add contacts +");
		//click on add contacts button
		d.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		Thread.sleep(2000);
		Reporter.log("add contacts");
		//click on dropdown of title
		d.findElement(By.xpath("(//a[@class='select2-choice'])[1]")).click();
		Thread.sleep(2000);
		Reporter.log("title dropdown ");
		//click on search bar & giving value
		d.findElement(By.xpath("(//div[@class='select2-result-label'])[3]")).click();
		Thread.sleep(2000);
		Reporter.log("to search the title");
		//giving firstname input
		d.findElement(By.name("firstname")).sendKeys(First);
		Thread.sleep(2000);
		Reporter.log("firstname");
		//giving lastname input 
		d.findElement(By.name("lastname")).sendKeys(Last);
		Thread.sleep(2000);
		Reporter.log("lastname");
		//scrolling opeartion
		JavascriptExecutor jse = (JavascriptExecutor) d ;
		jse.executeScript("window.scrollBy(0,200)");  
		Thread.sleep(4000);
		
		//click on assign to dropdown
		d.findElement(By.xpath("(//span[@class='select2-arrow'])[3]")).click();
		Thread.sleep(2000);
		Reporter.log("dropdown for assigned to");
		//click on search box
		WebElement drop = d.findElement(By.id("s2id_autogen6_search"));
		//passing the value as input
		drop.sendKeys(ASSIGNED);
		Thread.sleep(2000);
		//selecting the value
		drop.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Reporter.log("selecting the value from dropdown");
		//click on save button
		d.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);	
		Reporter.log("clicking on save button");
		
		
		//d.quit();
		 
	}
}
