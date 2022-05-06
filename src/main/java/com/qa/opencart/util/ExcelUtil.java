
package com.qa.opencart.util;

import java.io.FileInputStream; import java.io.FileNotFoundException; import
java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException; import
org.apache.poi.ss.usermodel.Sheet; import
org.apache.poi.ss.usermodel.Workbook; import
org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {


	private static final String EXCEL_TEST_DATA_PATH =  "./src/test/resources/testdata/OpenCartTestData.xlsx";

	private static Workbook workbook; 
	private static Sheet sheet;

	public static Object[][] getExcelTestData(String sheetName) {

		Object data[][] = null; 
		try { 
			FileInputStream is = new FileInputStream(EXCEL_TEST_DATA_PATH); 
			workbook = WorkbookFactory.create(is);
			sheet = workbook.getSheet(sheetName);

		} catch (FileNotFoundException e) { e.printStackTrace(); } catch
		(InvalidFormatException e) { e.printStackTrace(); } catch (IOException e) {
			e.printStackTrace(); }

		int rowCount = sheet.getLastRowNum(); int columnCount =
				sheet.getRow(0).getLastCellNum();

		data = new Object[rowCount][columnCount];

		for(int row = 0 ; row < rowCount ; row++) { for(int column = 0 ; column <
				columnCount ; column++) { data[row][column]=
				sheet.getRow(row+1).getCell(column).toString(); } } return data; }

}
