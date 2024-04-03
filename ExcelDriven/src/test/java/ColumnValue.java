import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ColumnValue {

	public int getColumnNumber(String fileName,String colname) throws IOException
	{
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		Iterator<Row> rows=worksheet.rowIterator();
		int column=0;
	    Row firstRow = rows.next();
	    Iterator<Cell> header = firstRow.cellIterator();
		while(header.hasNext())
		{
			Cell headercell = header.next();
			
			if(headercell.getStringCellValue().equalsIgnoreCase(colname))
			{
				break;
			}
			column++;
		}
		System.out.println(column);
		return column;
	
	}
	public int getRowNumber(String fileName,String fruitname) throws IOException
	{
			
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		Iterator<Row> rows=worksheet.rowIterator();
		int rowcount=0;
		int finish=0;
		
		while(rows.hasNext())
		{
			Row row = rows.next();
			Iterator<Cell> cell = row.cellIterator();
			while(cell.hasNext())
			{
				Cell eachcell = cell.next();
				//System.out.println(eachcell.getStringCellValue());
				String name;
				if(eachcell.getCellType()!=CellType.STRING)
				{
					name=NumberToTextConverter.toText(eachcell.getNumericCellValue());	
				}
				else
				{
					name=eachcell.getStringCellValue();
				}
				
				if(name.equalsIgnoreCase(fruitname))
				{
					
					finish++;
					break;
				}
			}
			if(finish==1)
			{
				break;
			}
			rowcount++;
			
			
		}
		System.out.println(rowcount);
		return rowcount;
	}
	public boolean updateCell(String fileName,int rowno, int colno, String value) throws IOException
	{
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		XSSFRow row = worksheet.getRow(rowno);
		XSSFCell col = row.getCell(colno);
		col.setCellValue(value);
		System.out.println(col.getStringCellValue());
		FileOutputStream fos=new FileOutputStream(fileName);
		workbook.write(fos);
		workbook.close();
		fis.close();
		return true;
	}
	

}
