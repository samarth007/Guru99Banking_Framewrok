package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLutils {

	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	
	public static int getRow(String xl, String xlsheet) throws IOException {
		fis= new FileInputStream(xl);
		wb= new XSSFWorkbook(fis);
		ws= wb.getSheet(xlsheet);
		int rowcount= ws.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;
	}
	
	public static int getColumn(String xl, String xlsheet, int rownum) throws IOException {
		fis= new FileInputStream(xl);
		wb= new XSSFWorkbook(fis);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		int colcount=row.getLastCellNum();
		wb.close();
		fis.close();
		return colcount;
		}
	
	
	public static String getCellData(String xl, String xlsheet, int rownum, int cellnum) throws IOException {
		fis= new FileInputStream(xl);
		wb= new XSSFWorkbook(fis);
		ws= wb.getSheet(xlsheet);
		row= ws.getRow(rownum);
	    cell = row.getCell(cellnum);
	    String data;
	    try {
	    	DataFormatter df = new DataFormatter();
	    	String cd= df.formatCellValue(cell);
	    	return cd;
	    }
	    catch(Exception e) {
	    	data="";
	    }
	    
	    wb.close();
	    fis.close();
	    return data;
	}
	
	public static void setCellData(String xl, String xlsheet, int rownum, int colnum, String data) throws IOException {
		fis= new FileInputStream(xl);
		wb= new XSSFWorkbook(fis);
		ws= wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
	    cell= row.createCell(colnum);
	    cell.setCellValue(data);
	    fos= new FileOutputStream(xl);
	    wb.write(fos);
	    wb.close();
	    fis.close();
	    fos.close();
	
	}
}
