package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	static String projectpath; 
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	 static XSSFCell cell;
	 
	 public ExcelUtil(String excelpath, String excelSheetname) {
		 try {
		 workbook = new XSSFWorkbook(excelpath);
		 sheet = workbook.getSheet(excelSheetname);
		 }
			catch(Exception exp) 
			{
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				exp.printStackTrace();
			}
	 }
	 
	 
 public static void main(String[] args) {
	// getRowcount();
	// getCellData(0,0);
 }
	
	public  int getRowcount()
	{
		int rowcount = 0;
		try {
		 rowcount = sheet.getPhysicalNumberOfRows();
		//System.out.println("No of Rows: " + rowcount);
		}
		catch(Exception exp) 
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowcount;
	}
	
	public  int getColcount()
	{
		int colcount = 0;
		try {
		 colcount = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("No of Columns: " + colcount);
		}
		catch(Exception exp) 
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colcount;
	}
	
	public  String getCellData(int rowNum, int colNum) {
		String cellData = null;
		try {
		cell =  sheet.getRow(rowNum).getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		 cellData = formatter.formatCellValue(cell);
	//	System.out.println(cellData);
		}
		catch(Exception exp) 
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
}
