package testing;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelCreator {
	public static void main(String[] args) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow Heading = sheet.createRow(0);
		Heading.createCell(0).setCellValue("SL.NO");
		Heading.createCell(1).setCellValue("Rule Name");
		Heading.createCell(2).setCellValue("Rule Type");

		for (int i = 1; i < 4; i++) {
			XSSFRow DataRows = sheet.createRow(i);
			XSSFCell SlnoRows = DataRows.createCell(0);
			SlnoRows.setCellValue(i);
			
			
			
			DataRows.createCell(1).setCellValue("RuleName" + " " + i);	
			DataRows.createCell(2).setCellValue("RuleType" + " " + i);

		}

		try {
			FileOutputStream FOP = new FileOutputStream("TestingExcelCreator.xlsx");
			workbook.write(FOP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
