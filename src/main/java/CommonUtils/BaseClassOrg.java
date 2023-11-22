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

public class BaseClassOrg {

	//organization testng
	public WebDriver d=null;
	
	FileUtils1 futils = new FileUtils1();
    WebDriverUtils wutils = new WebDriverUtils();
    ExcelUtils eutils = new ExcelUtils();
    JavaUtils jutils = new JavaUtils();
    
	@BeforeSuite
	public void BSConfig()  //connect to database
	{
		Reporter.log("--Connect to the database--",true);
	}

	
	@BeforeClass   //launch the url
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
	}
	
	@BeforeMethod
	public void BMConfig()
	{
		//click on sign in button
		d.findElement(By.xpath("//button[text()='Sign in']")).click();
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
	}
	
	@AfterClass
	public void ACConfig()
	{
		d.close();
	}
	
	@AfterSuite
	public void ASConfig()
	{
		Reporter.log("--Disconnect to the database",true);
	}
}
