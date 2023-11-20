package Components;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	
	
	public String getDataFromExcelSheet(String sheetname, int Rownum, int Cellnum) throws EncryptedDocumentException, IOException
	{
		
		
	FileInputStream fisexe = new FileInputStream("src\\test\\resources\\Vtiger.xlsx");
	Workbook wb = WorkbookFactory.create(fisexe);
	Sheet sh = wb.getSheet(sheetname);
	Row rw = sh.getRow(Rownum);
	Cell cl = rw.getCell(Cellnum);
	String value = cl.getStringCellValue();
	return value;
	 
	

	}

}
