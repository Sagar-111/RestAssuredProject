package api.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	private String path;
	
	 public XLUtility(String path){
		 this.path=path;
	 }
	 
	 public int getRowCount(String sheetName) throws IOException {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 int rowCount=sheet.getLastRowNum();
		 workbook.close();
		 fi.close();
		 return rowCount;		 
	 }
	 
	 public int getCellCount(String sheetName, int rownum) throws IOException {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rownum);
		 int cellCount=row.getLastCellNum();	 
		 workbook.close();
		 fi.close();
		 return cellCount;		 
	 }
	 	
	 public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		 fi=new FileInputStream(path);
		 workbook=new XSSFWorkbook(fi);
		 sheet=workbook.getSheet(sheetName);
		 row=sheet.getRow(rownum);
		 cell=row.getCell(colnum);	 
		 
		 DataFormatter formatter=new DataFormatter();//To get the data from the cell as it is(exactly as it appears in Excel)
		 String data;
		 try {
			 data=formatter.formatCellValue(cell);
		 }
		 catch(Exception e){
			 data="";
		 }
		 workbook.close();
		 fi.close();
		 return data;
	 }
	 
	 //Below this setCellData method is also there which is used for adding the data to the table;
	 //Mostly used in selenium will have to write at the time of selenium.
}