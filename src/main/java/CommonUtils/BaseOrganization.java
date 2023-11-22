package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POMProject.LoginPage;
import POMProject.OrganizationPage;

public class BaseOrganization {
	
	//pom organization testng

	public WebDriver d = null;
	
	FileUtils1 futils = new FileUtils1();
    WebDriverUtils wutils = new WebDriverUtils();
    ExcelUtils eutils = new ExcelUtils();
    JavaUtils jutils = new JavaUtils();
    
    
	@BeforeSuite
	public void dbCon()
	{
		Reporter.log("--Connect to the database--",true);
	}
	
	@BeforeClass
	public void lauch() throws IOException
	{
		 //to read data from property file 
	     String BROWSER= futils.getDataFromPropertyFile("Browser");
	     String URL = futils.getDataFromPropertyFile("Url");
		   
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
	}
	
	@BeforeMethod
	public void loginVtiger() throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		PageFactory.initElements(d, lp);
		Thread.sleep(2000);
		lp.getSubmitbtn().click();            //submit button
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logoutVtiger() throws InterruptedException
	{
		OrganizationPage org = new OrganizationPage();
		PageFactory.initElements(d, org);   // mandetory to write & avoid the exception
		org.getImg().click();    			// signout image
		Thread.sleep(2000);
		org.getLogout().click();      		//signout button
	}
	
	@AfterClass
	public void closeWindow()
	{
		d.close();
	}
	
	
	@AfterSuite
	public void dbDiscon() 
	{
		Reporter.log("--Disconnect the database--",true);
	}
}
