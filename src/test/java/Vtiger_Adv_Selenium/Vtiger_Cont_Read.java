package Vtiger_Adv_Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Vtiger_Cont_Read {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver d = null;
		
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger_cont.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		String BROWSER = p.getProperty("Browser");
		
		if(BROWSER.equals("Chrome"))
		{
			d = new ChromeDriver();
		}
		else if (BROWSER.equals("FireFox")) 
		{	
			d = new FirefoxDriver(); 
		}
		else if (BROWSER.equals("Edge"))
		{
			d = new EdgeDriver();
		}
		
		String URL = p.getProperty("Url");
		String FNAME = p.getProperty("FirstName");
		String LNAME = p.getProperty("LastName");
		
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		d.get(URL);
		d.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[text()=' MARKETING']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//span[text()=' Contacts'])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//a[@class='select2-choice'])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//div[@class='select2-result-label'])[3]")).click();
	    Thread.sleep(2000);
		d.findElement(By.name("firstname")).sendKeys(FNAME);
		d.findElement(By.name("lastname")).sendKeys(LNAME);
		Thread.sleep(2000);
		d.quit();
	}

}
