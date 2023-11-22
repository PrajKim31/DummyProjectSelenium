package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotations {

	@Test  // executed as per the order of sequence or flow of execution 
	public void vtiger() 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");  //2 executed
	}
	
	@BeforeSuite
	public void BSConfig()
	{
		//System.out.println("Connect to the database");   // 1 executed
		Reporter.log("Connect to the database",true);
	}
	
	@AfterSuite
	public void ASConfig()
	{
		//System.out.println("Disconnect to the database",true);  // 3 executed 
		Reporter.log("Disconnect to the database",true);
	}
}
