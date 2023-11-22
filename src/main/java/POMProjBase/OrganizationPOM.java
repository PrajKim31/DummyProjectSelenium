package POMProjBase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtils.BaseOrganization;
import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils1;
import CommonUtils.JavaUtils;
import CommonUtils.WebDriverUtils;
import POMProject.HomePage;
import POMProject.OrganizationPage;

public class OrganizationPOM extends BaseOrganization {

	//public WebDriver d=null;
	
	@Test
	public void login() throws InterruptedException, IOException {
		
		
		FileUtils1 futils = new FileUtils1();
	    WebDriverUtils wutils = new WebDriverUtils();
	    ExcelUtils eutils = new ExcelUtils();
	    JavaUtils jutils = new JavaUtils();
	    
	   
	    
	  //to read data from excel file
	    String OrgName = eutils.getDataFromExcelSheet("Sheet1",9,1); //rownum
		String Group = eutils.getDataFromExcelSheet("Sheet1",10,1); //colnum
		int organize = jutils.getRandomNumber(); 
			
			
			
			HomePage hp = new HomePage();
			PageFactory.initElements(d, hp);
			Thread.sleep(2000);
			Reporter.log("Clicking menu & selecting organization for POM");
			hp.getMenu().click();  //menu click
			Thread.sleep(2000);
			hp.getMarketing().click();   // marketing option
			Thread.sleep(2000);
			hp.getOrganization().click();   //organization option
			Thread.sleep(2000);
			hp.getAddorg().click();     // add organization button
			
			
			OrganizationPage org = new OrganizationPage();
			PageFactory.initElements(d, org);   // mandetory to write & avoid the exception
			Thread.sleep(2000);
			//org.getOrgnametf().sendKeys(OrgName);    //organization text field 
			
			org.getOrgnametf().sendKeys(OrgName+organize);  // passing the values from excel sheet with concatination of randomnumber
			Thread.sleep(2000);
			Reporter.log("Entering the organization name");
			org.getOrgnametf().sendKeys(Keys.PAGE_DOWN);   //scrolling
			Thread.sleep(2000);
			org.getAssignedto().click();   // assigned to dropdown
			Thread.sleep(2000);
			org.getMarket().sendKeys(Group);    //search field
			Thread.sleep(2000);
			org.getMarket().sendKeys(Keys.ENTER);    //search field text
			Thread.sleep(2000);
			Reporter.log("Assigining to the group");
			org.getSave().click();     // save button
			Thread.sleep(2000);
			Reporter.log("Saving the organization details");

		//d.quit();	
	}
	
}
