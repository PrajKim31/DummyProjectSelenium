package Vtiger_Adv_Selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Vtiger_Contacts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		WebDriver d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		d.manage().window().maximize();
		d.get("https://demo.vtiger.com/vtigercrm/");
		
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
	    d.findElement(By.name("firstname")).sendKeys("Prajakta");
		Thread.sleep(2000);
		d.findElement(By.name("lastname")).sendKeys("Kimbahune");
		Thread.sleep(2000);
		d.quit();
		
	}

}
