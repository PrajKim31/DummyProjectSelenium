package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassCont {

	//contacts testng
	public WebDriver d = null;
	
	FileUtils1 futils = new FileUtils1();
    WebDriverUtils wutils = new WebDriverUtils();
    ExcelUtils eutils = new ExcelUtils();
    JavaUtils jutils = new JavaUtils();
    
    @BeforeSuite
    public void BSConfig()  //connect to database
    {
    	Reporter.log("Connect to the database",true);
    }
    
    @BeforeClass    //launch the url
    public void BCConfig() throws IOException
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
	 
		//maximize window
		wutils.maximize(d);
		//implicit wait for url
		wutils.implicitWait(d);
	   //launching url
		d.get(URL);	
		Reporter.log("Launching the url",true);
    }
    
    @BeforeMethod
    public void BMConfig() throws InterruptedException
    {
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
		Reporter.log("Signing in to vtiger",true);
    }
    
    @AfterMethod
    public void AMConfig() throws InterruptedException
    {
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
    	Reporter.log("Signout from vtiger",true);
    }
    
    @AfterClass
    public void ACConfig()
    {
    	d.close();
    	Reporter.log("Closing the window",true);
    }
    
    @AfterSuite
    public void ASConfig()
    {
    	Reporter.log("Disconnect the database",true);
    }
}
