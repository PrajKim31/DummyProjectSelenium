package BasicOfTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FailTestScript {

	SoftAssert s = new SoftAssert();
	@Test 
	public void vtiger ()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.vtiger.com/vtigercrm/");
		String actualtitle = driver.getTitle();
		
		String expectedTitle = "vtigerpune";   // title is different from the actual website
		//softassert
		s.assertEquals(actualtitle, expectedTitle); // if condition is satisfied it will execute next lines
		System.out.println(actualtitle);
		System.out.println("Good Morning");
		s.assertAll();
		
		//hardassert
		//Assert.assertEquals(actualtitle, expectedTitle);  //if condition is not satisfied it will fetch the title if its matches 
		//System.out.println(actualtitle);
		//System.out.println("Good Morning");
	}

}
