package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String userDir;
	static XSSFWorkbook workbook;
	static XSSFSheet worksheet;
	public ExcelUtils(String excelDir, String sheet) {
		this.userDir = excelDir;
		try {
		 	workbook = new XSSFWorkbook(userDir+"/excel/data.xlsx");			 	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		this.worksheet =  workbook.getSheet(sheet);;
	}
	public static void main(String[] args) {
		userDir = System.getProperty("user.dir");
		
		ExcelUtils util = new ExcelUtils(userDir, "Sheet1");
		getRowCount();
		getColumnCount();
		getCellDataString(0,0);
	}
	public static int getRowCount() {		
		
		int rowcount = worksheet.getPhysicalNumberOfRows();

		System.out.println("Row count in excel file = "+rowcount);
		return rowcount;
		
	}
	public static int getColumnCount() {		
		
		int colcount = worksheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("Column count in excel file = "+colcount);
		return colcount ;
	
}

	public static String getCellDataString(int row, int col) {
		String cellData = null;
		if(worksheet != null) {
			cellData = worksheet.getRow(row).getCell(col).getStringCellValue();		
		}
		return cellData;
	}
		public static double getCellDataNumber(int row, int col) {
			double cellData = 0;
			if(worksheet != null) {
				cellData = worksheet.getRow(row).getCell(col).getNumericCellValue();				
			}
			return cellData;
	}
}
