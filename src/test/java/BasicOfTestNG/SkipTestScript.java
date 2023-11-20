package BasicOfTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SkipTestScript {

	@Test 
	public void Login()
	{
		System.out.println("LoginPage");
		Assert.assertEquals("Pune", "Deccan"); //fail
	}
	
	@Test(dependsOnMethods = "Login") 
	public void Home()
	{
		System.out.println("HomePage");  //pass
	}
	
	@Test(dependsOnMethods = "Login") 
	public void Logout()
	{
		System.out.println("LogoutPage"); //pass
	}
}
