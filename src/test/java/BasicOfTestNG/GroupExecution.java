package BasicOfTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GroupExecution {  // it will run the url what we grouped & we have to give the same group name to testng.xml

	@Test(groups = "socialmedia")
	
	public void facebook() 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		
	}
	
	@Test
	
	public void zomato()
	
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/india");
	}
	
	@Test(groups = "socialmedia")
	
	public void instagram()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
	}

}
