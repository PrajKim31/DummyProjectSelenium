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
import POMProject.ContactsPage;
import POMProject.LoginPage;

public class BaseContacts {
	
	//pom contacts testng

	public WebDriver d = null;
	
	FileUtils1 futils = new FileUtils1();
	WebDriverUtils wutils = new WebDriverUtils(); 
    ExcelUtils eutils = new ExcelUtils();
    JavaUtils jutils = new JavaUtils();
    
    
	@BeforeSuite
	public void dbCont()
	{
		Reporter.log("Connect to the database",true);
	}
	
	@BeforeClass
	public void lauch() throws IOException
	{
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
	
		d.get(URL);				// lauch url
		wutils.maximize(d);  // maximize the window
		wutils.implicitWait(d);  // implicit wait for url
	}
	
	@BeforeMethod   //login page
	public void login() throws InterruptedException
	{
		LoginPage lp = new LoginPage();
		PageFactory.initElements(d, lp); 
		Thread.sleep(2000);
		lp.getSubmitbtn().click();		//submit button
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		ContactsPage cp = new ContactsPage();
		PageFactory.initElements(d, cp);
		cp.getImg().click();						//signout option
		Thread.sleep(2000);
		cp.getLogout().click();						//signout button
	}
	
	@AfterClass  //closing window
	public void closeWindow()
	{
		d.close();
	}
	
	
	@AfterSuite   // disconnect the database
	public void DBdisCon()
	{
		Reporter.log("Disconnect to the database",true);
	}
}
