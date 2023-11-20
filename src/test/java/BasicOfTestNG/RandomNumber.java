package BasicOfTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RandomNumber {

	@Test(priority=3)
	
	public void facebook() 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com/");
		
	}
	
	@Test(invocationCount=2, priority=1)
	
	public void zomato()
	
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zomato.com/india");
	}
	
	@Test(priority=2)
	
	public void instagram()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/");
	}

}
