package Vtiger_Adv_Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Vtiger_Orgn_Read {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver d = null;
		
		FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger_organization.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		 
		String BROWSER = p.getProperty("Browser");
		
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
		
		String URL = p.getProperty("Url");
		String AccName = p.getProperty("Accname");
		//String Support = p.getProperty("Assigned");
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		d.get(URL);
		d.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("//span[text()=' MARKETING']")).click();
		Thread.sleep(2000);
		d.findElement(By.xpath("(//span[text()=' Organizations'])[1]")).click();
		Thread.sleep(2000);
		d.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")).click();
		Thread.sleep(2000);
		d.findElement(By.name("accountname")).sendKeys(AccName);
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor) d ;
		jse.executeScript("window.scrollBy(0,200)");  
		Thread.sleep(2000);
		
		d.findElement(By.xpath("(//span[@class='select2-arrow'])[4]")).click();
		
		String Support = p.getProperty("Assigned");
		d.findElement(By.id("s2id_autogen8_search")).sendKeys(Support);
		Thread.sleep(2000);
		WebElement select = d.findElement(By.xpath("//span[text()='Marketing Group']"));
		
		Actions a = new Actions(d);
		a.moveToElement(select).click();
		a.perform();
		
		Thread.sleep(2000);
		d.quit();
	}

}
