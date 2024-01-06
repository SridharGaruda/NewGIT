package testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestingXLReader {

	static String ExcelFilePath = "G:\\Sridhar\\code\\NewGIT\\src\\test\\java\\com\\testdata\\Automation_Testcases.xlsx";

	public static void ReadData() {

		try {
			FileInputStream FIP = new FileInputStream(ExcelFilePath);

			XSSFWorkbook workbook = new XSSFWorkbook(FIP);

			XSSFSheet sheet = workbook.getSheet("RulesTestData");

			int rowscount = sheet.getPhysicalNumberOfRows();

			for (int r = 1; r < rowscount; r++) { // Start from 1 to skip the header row

				XSSFRow row = sheet.getRow(r);

				int SLNO = (int) row.getCell(0).getNumericCellValue();
				String RuleName = row.getCell(1).getStringCellValue();
				String RuleType = row.getCell(2).getStringCellValue();

				System.out.println(SLNO + " " + RuleName + " " + RuleType);

				FIP.close();
			}
		} catch (IOException e) {
			System.out.println("there was an errro in reading data");
		}

	}

	public static void WriteData() {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TestData");
		XSSFRow HeaderRow = sheet.createRow(0);
		XSSFCellStyle cellStyle = workbook.createCellStyle();
//		cellStyle.setAlignment(HorizontalAlignment.CENTER);
//		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		HeaderRow.createCell(0).setCellValue("SL.NO");
		HeaderRow.createCell(1).setCellValue("Rule Name");
		HeaderRow.createCell(2).setCellValue("Rule Type");

		XSSFCellStyle DataStyle = workbook.createCellStyle();
		DataStyle.setBorderTop(BorderStyle.THIN);
		DataStyle.setBorderBottom(BorderStyle.THIN);
		DataStyle.setBorderLeft(BorderStyle.THIN);
		DataStyle.setBorderRight(BorderStyle.THIN);

		XSSFCellStyle DataStyle1 = workbook.createCellStyle();
		DataStyle1.cloneStyleFrom(DataStyle);
		DataStyle1.setAlignment(HorizontalAlignment.CENTER);

		for (int i = 1; i <= 4; i++) {
			XSSFRow dataRow = sheet.createRow(i);

			// Center the text in the SL.NO column
			XSSFCell dataCell1 = dataRow.createCell(0);
			dataCell1.setCellValue(i);
			dataCell1.setCellStyle(DataStyle1);

			XSSFCell dataCell2 = dataRow.createCell(1);
			dataCell2.setCellValue("RuleName" + i);
			dataCell2.setCellStyle(DataStyle);

			XSSFCell dataCell3 = dataRow.createCell(2);
			dataCell3.setCellValue("RuleType" + i);
			dataCell3.setCellStyle(DataStyle);

//			dataCell1.getCellStyle().setAlignment(HorizontalAlignment.CENTER);

		}

		try (FileOutputStream FOP = new FileOutputStream("TestData.xlsx")) {
			workbook.write(FOP);
			System.out.println("File created succesfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object[][] getTestData(String SheetName) {
		Object[][] data = null;
		try {
			FileInputStream Excelreader = new FileInputStream(ExcelFilePath);
			XSSFWorkbook book = new XSSFWorkbook(Excelreader);
			XSSFSheet sheet = book.getSheet("RulesTestData");
			System.out.println(sheet.getLastRowNum());
			System.out.println(sheet.getRow(0).getLastCellNum());
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i +1).getCell(j).toString();
//					System.out.println(data[i][j]);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;

	}

	public static void main(String[] args) throws IOException {
		Object[][] data = DataDrivenTestingXLReader.getTestData("RulesTestData");
		System.out.print(data[0][0]+" ");
		System.out.print(data[0][1]+" ");
		System.out.print(data[0][2]+" ");
		System.out.println(data[0][3]);
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.print(data[i][j] + " ");
			}
			System.out.println(); // Move to the next line after each row
		}
	}
}
