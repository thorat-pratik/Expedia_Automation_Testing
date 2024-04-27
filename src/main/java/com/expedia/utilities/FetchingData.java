package com.expedia.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FetchingData {
public static Object[][] fetchdata() throws IOException {
		
		
		String datafilepath = System.getProperty("user.dir")+"/resources/testdata.xlsx";

		FileInputStream fis = new FileInputStream(datafilepath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		int rowcount = sheet.getPhysicalNumberOfRows();
		
		int colcount = 1;
				//sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] dataObj = new Object[rowcount][colcount];
		
		for(int loopcount = 0; loopcount < rowcount; loopcount++) {
			
			Row row = sheet.getRow(loopcount);
			
			for(int i = 0; i <colcount; i++) {
				dataObj[loopcount][i] = row.getCell(i).getStringCellValue();				
			}
		}
		
		workbook.close();
		fis.close();
		return dataObj;
		
	}

	public static void writestatus(int rowcount, boolean status) throws IOException {
		
		
		String datafilepath = System.getProperty("user.dir")+"/Data/testdata.xlsx";
		FileInputStream fis = new FileInputStream(datafilepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(rowcount);
		
		
		FileOutputStream fos = new FileOutputStream(new File(datafilepath));
		if(row.getPhysicalNumberOfCells()==1)
			row.createCell(row.getPhysicalNumberOfCells());
		
		
		if(status)
			row.getCell(row.getPhysicalNumberOfCells()-1).setCellValue("Pass");
		else
			row.getCell(row.getPhysicalNumberOfCells()-1).setCellValue("Fail");
		
		
		workbook.write(fos);

		fos.close();
		fis.close();
		
	}


	

}
