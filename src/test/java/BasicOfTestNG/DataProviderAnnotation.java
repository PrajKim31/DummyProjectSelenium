package BasicOfTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotation {

	
	@Test (dataProvider = "loginData")
	public void facebook(String name, String password)
	{
		System.out.println("My name is :"+name+ " & password"+password);
	}
	
	@DataProvider
	public Object[][] loginData()  // one method giving the data to another i.e facebook method
	{
		Object[][] j = new Object[3][2];  //return type
		j[0][0] = "Akash";
		j[0][1] = "ak21";
		j[1][0] = "Prajakta";
		j[1][1] = "praj31";
		j[2][0] = "Pk";
		j[2][1] = "psk99";
		return j;
	}
}
