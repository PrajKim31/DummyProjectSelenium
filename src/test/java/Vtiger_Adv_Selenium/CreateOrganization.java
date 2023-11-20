package Vtiger_Adv_Selenium;

import java.io.IOException;
//import java.time.Duration;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;*/
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;

import Components.ExcelUtils;
import Components.FileUtils1;
import Components.WebDriverUtils;

public class CreateOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	    WebDriver d=null;
	   
        /*FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger_organization.properties");
		Properties p = new Properties();
		p.load(fis);*/ //instead we use below 
	    
	    FileUtils1 futils = new FileUtils1();
	    WebDriverUtils wutils = new WebDriverUtils();
	    ExcelUtils eutils = new ExcelUtils();
	    
	    //to read data from property file
	    String BROWSER= futils.getDataFromPropertyFile("Browser");
	    String URL = futils.getDataFromPropertyFile("Url");
	  //  String ASSIGNED = futils.getDataFromPropertyFile("Assigned");
		
		/*String BROWSER = p.getProperty("Browser");
		String URL = p.getProperty("Url");
		String ASSIGNED = p.getProperty("Assigned");*/
		
	  //to read data from excel file
		   String OrgName = eutils.getDataFromExcelSheet("Sheet1",9,1); //rownum
		   String Group = eutils.getDataFromExcelSheet("Sheet1",10,1); //colnum
	    
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
	
		//maximize window
		wutils.maximize(d);
		 //implicit wait for url
		wutils.implicitWait(d);
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		 //launching url
		d.get(URL);
		//click on sign in button
		d.findElement(By.xpath("//button[text()='Sign in']")).click();
		//click on menu option
		d.findElement(By.xpath("(//span[@class='app-icon fa fa-bars'])[1]")).click();
		//click on marketing option
		d.findElement(By.xpath("//span[text()=' MARKETING']")).click();
		//click in organization option
		d.findElement(By.xpath("(//span[text()=' Organizations'])[1]")).click();
		//click on add organization
		d.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")).click();
		
		
		
		/*FileInputStream fisexe = new FileInputStream("src\\test\\resources\\Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fisexe);*/ // instead we use below 
		
		
		//Sheet sh = wb.getSheet("Sheet1");	
		/*Row rw2 = sh.getRow(9);
		Cell cl2 = rw2.getCell(1); 
		String data2 = cl2.getStringCellValue(); */
		
	
		//giving organization name input
		d.findElement(By.name("accountname")).sendKeys(OrgName); //pass the variable from eutils
		Thread.sleep(2000);
		
		//scrolling operation
		JavascriptExecutor jse = (JavascriptExecutor) d ;
		jse.executeScript("window.scrollBy(0,200)");  
		Thread.sleep(4000);
		
		// click on assigned to dropdown
		WebElement click = d.findElement(By.xpath("(//span[@role='presentation'])[4]"));
		wutils.action(d, click);  // for clicking
		Thread.sleep(2000);
		//click on search bar
		WebElement drop = d.findElement(By.id("s2id_autogen8_search"));
		//passing the values to search bar
		drop.sendKeys(Group);
		Thread.sleep(2000);
		//clicking on the targeted element
		drop.sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		
		 // click on checkbox 
		WebElement box = d.findElement(By.id("Accounts_editView_fieldName_notify_owner"));
		wutils.action(d, box);  
		
		Thread.sleep(2000);
		
		WebElement contextclick = d.findElement(By.name("website"));
		wutils.rightClick(d, contextclick);   //contextclick
		
		Thread.sleep(2000);
		
		WebElement dropdown = d.findElement(By.xpath("(//span[@class='select2-arrow'])[2]"));
		wutils.action(d, dropdown);			//dropdown
		
		
		
		
		
		//d.quit();
		
		
	}

}
