package POMProjBase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Components.ExcelUtils;
import Components.FileUtils1;
import Components.JavaUtils;
import Components.WebDriverUtils;
import POMProject.HomePage;
import POMProject.LoginPage;
import POMProject.OrganizationPage;

public class VtigerOrganization {
	//testNG code
	@Test 
	 
	public void login() throws InterruptedException, IOException {
		WebDriver d=null;
		
		FileUtils1 futils = new FileUtils1();
	    WebDriverUtils wutils = new WebDriverUtils();
	    ExcelUtils eutils = new ExcelUtils();
	    JavaUtils jutils = new JavaUtils();
	    
	  //to read data from property file
	    String BROWSER= futils.getDataFromPropertyFile("Browser");
	    String URL = futils.getDataFromPropertyFile("Url");
	    
	    
	  //to read data from excel file
		   String OrgName = eutils.getDataFromExcelSheet("Sheet1",9,1); //rownum
		   String Group = eutils.getDataFromExcelSheet("Sheet1",10,1); //colnum
		   int organize = jutils.getRandomNumber();
		   
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
		
			d.get(URL);
			wutils.maximize(d);
			wutils.implicitWait(d);
			
			
			LoginPage lp = new LoginPage();
			PageFactory.initElements(d, lp);
			Thread.sleep(2000);
			lp.getSubmitbtn().click();    //submit button
			Thread.sleep(2000);
			
			
			HomePage hp = new HomePage();
			PageFactory.initElements(d, hp);
			Thread.sleep(2000);
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
			
			org.getOrgnametf().sendKeys(Keys.PAGE_DOWN);   //scrolling
			Thread.sleep(2000);
			org.getAssignedto().click();   // assigned to dropdown
			Thread.sleep(2000);
			org.getMarket().sendKeys(Group);    //search field
			Thread.sleep(2000);
			org.getMarket().sendKeys(Keys.ENTER);    //search field text
			Thread.sleep(2000);
			org.getSave().click();     // save button
			Thread.sleep(2000);
			org.getImg().click();     // signout image
			Thread.sleep(2000);
			org.getLogout().click();      //signout button
			
			
			
	}

}
