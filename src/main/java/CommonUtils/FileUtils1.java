package CommonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils1 {
	
		public String getDataFromPropertyFile(String key) throws IOException
		{
			FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger_cont.properties");
			Properties p = new Properties();
			p.load(fis);  // 3 ,mandetory lines
			String value =  p.getProperty(key);  //key is in the form of string
			return value;
		}
	}


