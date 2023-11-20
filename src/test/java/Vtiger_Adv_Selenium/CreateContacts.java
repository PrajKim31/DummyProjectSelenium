package Vtiger_Adv_Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContacts {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver d = null;
		   
        FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger_cont.properties");
		Properties p = new Properties();
		p.load(fis);
		
		String BROWSER = p.getProperty("Browser");
		String URL = p.getProperty("Url");
		String FNAME = p.getProperty("FirstName");
		String LNAME = p.getProperty("LastName");
		
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
		
		/*String URL = p.getProperty("Url");
		String FNAME = p.getProperty("FirstName");
		String LNAME = p.getProperty("LastName");*/
		
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
	    
		
		FileInputStream fisexe = new FileInputStream("src\\test\\resources\\Vtiger.xlsx");
		 
		Workbook wb = WorkbookFactory.create(fisexe);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		Row rw1 = sh.getRow(2);
		Cell cl1 = rw1.getCell(1);
		String data1 = cl1.getStringCellValue();
		System.out.println(data1);
		
		Row rw2 = sh.getRow(3);
		Cell cl2 = rw2.getCell(1); 
		String data2 = cl2.getStringCellValue();
		System.out.println(data2);
		
		d.findElement(By.name("firstname")).sendKeys(FNAME);
		d.findElement(By.name("lastname")).sendKeys(LNAME);

		d.quit();
	}

}
