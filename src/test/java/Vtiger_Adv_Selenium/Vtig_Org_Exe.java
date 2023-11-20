package Vtiger_Adv_Selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Vtig_Org_Exe {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("src\\test\\resources\\Vtiger.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		Row rw = sh.getRow(7);
		Cell cl = rw.getCell(1); 
		String data = cl.getStringCellValue();
		System.out.println(data);
		
		Row rw1 = sh.getRow(8);
		Cell cl1 = rw1.getCell(1);
		String data1 = cl1.getStringCellValue();
		System.out.println(data1);
		
		Row rw2 = sh.getRow(9);
		Cell cl2 = rw2.getCell(1); 
		String data2 = cl2.getStringCellValue();
		System.out.println(data2);
		 
	}

}
