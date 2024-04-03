import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class RowValue {

	@Test
	public void getRowNumber() throws IOException
	{
		String fileName="C:\\Users\\rannepu\\Downloads\\download.xlsx";
		String fruitname="Apple";		
		FileInputStream fis=new FileInputStream(fileName); 
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet worksheet = workbook.getSheetAt(0);
		Iterator<Row> rows=worksheet.rowIterator();
		int rowcount=0;
		int finish=0;
		Row row = rows.next();
		while(rows.hasNext())
		{
			
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
				System.out.println(name);
				if(name.equalsIgnoreCase(fruitname))
				{
					
					finish++;
					
				}
			}
			if(finish==1)
			{
				
			}
			row=rows.next();
			rowcount++;
			System.out.println(rowcount);
			
		}
	}

}
