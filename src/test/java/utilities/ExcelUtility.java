package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static XSSFWorkbook wb ;
	static XSSFSheet sheet;
//	static String proPath=System.getProperty("user.dir");
	public static String path ="D:/eclips/SeleniumMavenFramework_Demo/ExcelFile/Data.xlsx";
	static FileInputStream fis;
	
	public ExcelUtility(String ePath, String sheetName) {
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
			sheet =wb.getSheet("Sheet1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		ExcelUtility ob = new ExcelUtility(path, "Sheet1");
		System.out.println("no. of rows : "+ob.getRowCount());
		System.out.println("no of cell : "+ob.getCellCount(0));

		System.out.println(ob.getNumericValue(1, 1));
		System.out.println(ob.getValueFromExcel(1, 0));
		
		
	}
	
	public static int getRowCount() {
		int noOfRows = 0;
		
		try {
			noOfRows = sheet.getPhysicalNumberOfRows();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return noOfRows;
		
	}
	public static int getCellCount(int rowNo) {
		int noOfCell = 0;
		
		try {
			noOfCell = sheet.getRow(rowNo).getPhysicalNumberOfCells();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return noOfCell;
		
	}
	public static double getNumericValue(int rowNo,int cellNo) {
		double value=0.0;
		try {
			value = sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return value;
	}
	public static String getValueFromExcel(int rowNo,int cellNo) {
		String value = null;
		try {
			value = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		return value;
		
	}

}
