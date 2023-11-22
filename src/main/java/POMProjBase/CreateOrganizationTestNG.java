package POMProjBase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;*/
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtils.BaseClassOrg;
import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils1;
import CommonUtils.JavaUtils;
import CommonUtils.WebDriverUtils;

public class CreateOrganizationTestNG extends BaseClassOrg {

		
	   // public WebDriver d;   // it will only did login & logout
	    @Test 
	    public void organization() throws EncryptedDocumentException, IOException, InterruptedException {
	    	
	    	FileUtils1 futils = new FileUtils1();
	        WebDriverUtils wutils = new WebDriverUtils();
	        ExcelUtils eutils = new ExcelUtils();
	        JavaUtils jutils = new JavaUtils();
	        
		
	  //to read data from excel file
		   String OrgName = eutils.getDataFromExcelSheet("Sheet1",9,1); //rownum
		   String Group = eutils.getDataFromExcelSheet("Sheet1",10,1); //colnum
	    
	
		Reporter.log("Clicking on menu & selecting the organization");
		//click on menu option
		d.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		//click on marketing option
		d.findElement(By.xpath("//span[text()=' MARKETING']")).click();
		//click in organization option
		d.findElement(By.xpath("(//span[text()=' Organizations'])[1]")).click();
		//click on add organization
		d.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")).click();
	
		//giving organization name input
		d.findElement(By.name("accountname")).sendKeys(OrgName); //pass the variable from eutils
		Thread.sleep(2000);
		Reporter.log("Entering the organization name");
		
		//scrolling operation
		JavascriptExecutor jse = (JavascriptExecutor) d ;
		jse.executeScript("window.scrollBy(0,200)");  
		Thread.sleep(4000);
		
		// click on assigned to dropdown
		WebElement click = d.findElement(By.xpath("(//span[@role='presentation'])[4]"));
		wutils.action(d, click);  // for clicking
		Thread.sleep(2000);
		//click on search bar
		WebElement drop = d.findElement(By.id("s2id_autogen8_search"));
		//passing the values to search bar
		drop.sendKeys(Group);
		Thread.sleep(2000);
		//clicking on the targeted element
		drop.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		Reporter.log("Selecting the group for organization");
		
		 // click on checkbox 
		WebElement box = d.findElement(By.id("Accounts_editView_fieldName_notify_owner"));
		wutils.action(d, box);  
		Thread.sleep(2000);
		Reporter.log("Selecting the checkbox");
		//click on save button
		d.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);	
		Reporter.log("Clicking on save button");
				
		
		
		//d.quit();
		
		
	}

}
