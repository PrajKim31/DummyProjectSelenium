package POMProjBase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtils.BaseContacts;
import CommonUtils.ExcelUtils;
import CommonUtils.FileUtils1;
import CommonUtils.JavaUtils;
import CommonUtils.WebDriverUtils;
import POMProject.ContactsPage;
import POMProject.HomePage;

public class ContactsPOM extends BaseContacts{

	//public WebDriver d = null;
	
	// testNG code 
		@Test 
		 
		public void signin() throws InterruptedException, IOException {  // finish testNG code

			
			
			FileUtils1 futils = new FileUtils1();
			WebDriverUtils wutils = new WebDriverUtils(); 
		    ExcelUtils eutils = new ExcelUtils();
		    JavaUtils jutils = new JavaUtils();
		    
		  //to read data from property file
		    int FirstN = jutils.getRandomNumber();
		    
		    
		  //to read data from excel file
			  String FNAME = eutils.getDataFromExcelSheet("Sheet1",2,1); 
			  String LNAME = eutils.getDataFromExcelSheet("Sheet1",3,1); 
			  String ASSIGN = eutils.getDataFromExcelSheet("Sheet1",4,1);
			   
			   
				
				HomePage hp = new HomePage();
				PageFactory.initElements(d, hp);
				Thread.sleep(2000);
				hp.getMenu().click();			//menu option
				Thread.sleep(2000);
				Reporter.log("Clicking on menu & selecting contacts option");
				hp.getMarketing().click();		//marketing option
				Thread.sleep(2000);
				hp.getContacts().click();		//contacts option
				Thread.sleep(2000);
				hp.getAddcont().click();		// add contacts button
				Thread.sleep(2000);
				
				 
				ContactsPage cp = new ContactsPage();
				PageFactory.initElements(d, cp);
				Thread.sleep(2000);
				cp.getDroparrow().click();				// dropdown for title of name
				Thread.sleep(2000);
				cp.getSearch().sendKeys("Ms");	 		//searchbar for title
				Thread.sleep(2000);
				cp.getSearch().sendKeys(Keys.ENTER);	//entering title to searchbar
				Thread.sleep(2000);
				//cp.getFname().sendKeys(FNAME);			//firstname textfield
				
				cp.getFname().sendKeys(FNAME+FirstN);  		//firstname with random number 
				Thread.sleep(2000);
				Reporter.log("Firstname is entered with title");
				cp.getLname().sendKeys(LNAME);			//lastname textfield
				Thread.sleep(2000);
				Reporter.log("Lastname is entered");
				cp.getLname().sendKeys(Keys.PAGE_DOWN);  //page scrolling 
				Thread.sleep(2000);
				cp.getAssign().click(); 				  // Assigned to dropdown
				Thread.sleep(2000);
				cp.getSearchassign().sendKeys(ASSIGN);	  // searchbar for assigned to
				Thread.sleep(2000);
				cp.getSearchassign().sendKeys(Keys.ENTER); // clicking to the value 
				Thread.sleep(2000);
				Reporter.log("Assigining to the group");
				wutils.screenshot(d);						// taking screenshot of page
				Thread.sleep(2000);							
				cp.getSave().click();						// save button
				Thread.sleep(2000);
				Reporter.log("saving the contact");
				
	//	d.quit();
		
		}
}
