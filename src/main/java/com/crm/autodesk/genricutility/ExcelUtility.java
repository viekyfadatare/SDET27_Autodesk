package com.crm.autodesk.genricutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author admin
 *
 */
public class ExcelUtility {
	/**
	 * It is Used to get date From Excel Sheeet
	 * 
	 * @param SheetName
	 * @param Path
	 * @param Row
	 * @param Col
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromExcelSheet(String SheetName, int Row, int Col) throws Throwable {

		FileInputStream fis = new FileInputStream("./Data/orgnasation.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Cell cl = sh.getRow(Row).getCell(Col);
		wb.close();
		return cl.toString();
	}

	/**
	 * Used to lat row number on specified sheet
	 * 
	 * @param SheetName
	 * @param Path
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String SheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/orgnasation.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		wb.close();
		return sh.getLastRowNum();
	}
/**
-, * --------------------------------This Methos is used to Set The data in Excel fileui
 * @param SheetName
 * @param Path
 * @param Row
 * @param Col
 * @param data
 * @throws Throwable
 */
	public void setDataExcelSheet(String SheetName, int Row, int Col, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/orgnasation.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Cell cl = sh.getRow(Row).getCell(Col);
		cl.setCellFormula(data);
		FileOutputStream fos = new FileOutputStream("./Data/orgnasation.xlsx");
		wb.write(fos);
		wb.close();
		
		

	}

}
