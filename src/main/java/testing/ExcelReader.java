package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static void main(String[] args) {
		
		try {
			FileInputStream FIP = new FileInputStream(
					"G:\\Sridhar\\code\\NewGIT\\src\\test" + "\\java\\com\\testdata\\Automation_Testcases.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(FIP);
			XSSFSheet sheet = workbook.getSheet("RulesTestData");
			int RowsCount = sheet.getPhysicalNumberOfRows();

			for (int r = 1; r < RowsCount; r++) {
				XSSFRow row = sheet.getRow(r);

				int slno = (int) row.getCell(0).getNumericCellValue();
				String RuleName = row.getCell(1).getStringCellValue();
				String RuleType = row.getCell(2).getStringCellValue();
				System.out.println(slno+" "+RuleName+" "+RuleType);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
