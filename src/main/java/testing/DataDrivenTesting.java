package testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting {

	public static void main(String[] args) throws IOException {
		String ExcelFilePath = "G:\\Sridhar\\code\\NewGIT\\src\\test\\java\\com\\testdata\\Automation_Testcases.xlsx" ;
		
		FileInputStream FP = new FileInputStream(ExcelFilePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(FP);
		
//		XSSFSheet sheet = workbook.getSheet("RulesTestData");
		// you can use index also to get the sheet
		XSSFSheet sheet =  workbook.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for(int r=0; r<=rows; r++)
		{
           XSSFRow row = sheet.getRow(r);
           
           for(int c=0; c<cols; c++)
           {
        	 XSSFCell cell = row.getCell(c);
        	 
        	 switch(cell.getCellType())
        	 {
        	 case STRING: System.out.println(cell.getStringCellValue()); break;
        	 case NUMERIC: System.out.println(cell.getNumericCellValue()); break;
        	 case BOOLEAN: System.out.println(cell.getBooleanCellValue()); break;
			default:
				break;
			
        	 }
        	 
           }
		}
		
		
	}
}
