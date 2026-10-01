package org.automationexercise.qa.util;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automationexercise.qa.util.TestUtil;

public class TestUtil {
	public String path;
	FileInputStream fis;
	XSSFWorkbook workbook ;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell ;
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	
	/*public static DataFormatter formatter = new DataFormatter();
	public static String Test_Sheet_Path = "D:\\Data\\Details.xlsx";

	@DataProvider(name = "Data")
	public static Object[][] getData() throws IOException {

		FileInputStream file;

		file = new FileInputStream(Test_Sheet_Path);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		Object data[][] = new Object[rowcount - 1][colCount];
		for (int i = 0; i < rowcount - 1; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < colCount; j++) {

				XSSFCell cell = row.getCell(j);

				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		return data;
		}
*/
	public TestUtil(String path)
	{
		this.path=path;
		try {
			 fis = new FileInputStream(path);
			 workbook = new  XSSFWorkbook(fis);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getCellData(String sheetName,String colName,int rowNum)
	{
		try {
			int col_Num = 0;
			int index=workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().equals(colName)) {
					 col_Num=i;
				}	
			}
			row=sheet.getRow(rowNum-1);
			XSSFCell cell = row.getCell(col_Num);
			if(cell.getCellType() == CellType.STRING )
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType() == CellType.NUMERIC)
			{
				return String.valueOf(cell.getNumericCellValue());
			}
			else if(cell.getCellType() == CellType.BOOLEAN)
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
			else if(cell.getCellType() == CellType.BLANK)
			{
				return "";

			}
			
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return null;
		
	}
	
	public String getCellData(String sheetName,int colName,int rowNum)
	{
		try {
			int index=workbook.getSheetIndex(sheetName);
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(0);
			row=sheet.getRow(rowNum-1);
			XSSFCell cell = row.getCell(colName);
			if(cell.getCellType() == CellType.STRING )
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType() == CellType.NUMERIC)
			{
				return String.valueOf(cell.getNumericCellValue());
			}
			else if(cell.getCellType() == CellType.BOOLEAN)
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
			else if(cell.getCellType() == CellType.BLANK)
			{
				return "";

			}
			
		}
		catch(Exception e) {
		e.printStackTrace();
		}
		return null;
		
	}
	public int getRowCount(String sheetName)
	{
		try 
		{
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1)
		{
			return 0;
		}
		else
		{
			sheet=workbook.getSheetAt(index);
			int number=sheet.getLastRowNum()+1;
			return number;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;		
		
	}
	public int getColumnCount(String sheetName)
	{
		try {
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1)
		{
			return 0;
		}
		else
		{
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(0);
			return row.getLastCellNum();
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	public static Object[][]getData(String ExcelName,String testcase)
	{
		String path="D:\\Data\\Details.xlsx";
		TestUtil Data=new TestUtil(path);
		int rowNum=Data.getRowCount(testcase);
		int colNum=Data.getColumnCount(testcase);
		Object sampleData[][]=new Object[rowNum-1][colNum];
		
		for(int i=2;i<=rowNum;i++)
		{
			for(int j=0;j<colNum;j++)
			{
				sampleData[i-2][j]=Data.getCellData(testcase, j, i);
			}
		}
		return sampleData;
		
	}

}
