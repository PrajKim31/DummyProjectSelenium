package BasicOfTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTrueFalse {

	@Test
	
	public void vtigercrm()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement loginbtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
		// assertTrue():
		// Assert.assertTrue(loginbtn.isEnabled()); // if cond is true it will going to execute next line  //pass
		//Assert.assertTrue(loginbtn.isSelected()); // fail
		Assert.assertTrue(loginbtn.isDisplayed());  // pass 
		
		//assertFalse() :
		Assert.assertFalse(loginbtn.isDisplayed()); //fail
		Assert.assertFalse(loginbtn.isEnabled()); //fail
		Assert.assertFalse(loginbtn.isSelected()); //pass
		
		System.out.println("Hi");
		
	}
}
