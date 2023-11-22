package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BCACAnnotations {

	@BeforeSuite
	public void BSConfig()
	{   
		Reporter.log("--Connect to the database--",true); // 1 executed
	}
	
	
	@BeforeClass
	public void BCConfig()
	{   
		Reporter.log("--Launch the browser--",true); 	// 2 executed
	}
	
	
	@Test  // executed as per the order of sequence or flow of execution 
	public void vtiger() 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");  //3 executed
	}
	
	@AfterClass 
	public void ACConfig()
	{
		Reporter.log("--Close the browser--",true);    // 4 executed
	}
	
	@AfterSuite
	public void ASConfig()
	{
		Reporter.log("Disconnect to the database",true);		 // 5 executed 
	}
}
