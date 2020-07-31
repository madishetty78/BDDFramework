package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src = new File ("./TestData/Data_Input.xlsx");
				
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
				System.out.println("Unable to read Excel File " + e.getMessage());
		}
	}
	
	
	// Method Overloading Concept is applied here
	
	// Need to provide the Excel sheet name for this method
	public String getStringData(String SheetName, int row, int col)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	// Need to provide the Excel sheet Index for this method
	public String getStringData(int SheetIndex, int row, int col)
	{
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	
	public double getNumericData(String SheetName, int row, int col)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
