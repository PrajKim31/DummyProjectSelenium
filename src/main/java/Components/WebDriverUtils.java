package Components;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtils {


		public void maximize(WebDriver d)
		{
			d.manage().window().maximize();
		}
		
		public void minimize(WebDriver d)
		{
			d.manage().window().minimize();
		}
		
		public void implicitWait(WebDriver d)
		{
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
		
		public void action(WebDriver d, WebElement elementname)
		{
			Actions a = new Actions(d);
			a.click(elementname);
			a.perform();
		}
		
		public void rightClick(WebDriver d, WebElement elementname)
		{
			Actions a = new Actions(d);
			a.contextClick(elementname);
			a.perform();
		}
		
		public void movoTo(WebDriver d, WebElement elementname)
		{
			Actions a = new Actions(d);
			a.moveToElement(elementname);
			a.perform();
		}
		
		public void screenshot(WebDriver d) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)d; 
			File tempfile = ts.getScreenshotAs(OutputType.FILE);
			File destinationfile = new File("./image/vtiger.jpg");  //concatination operation
			FileUtils.copyFile(tempfile,destinationfile);
			
		}
	
	}


	


