import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("C:\\Users\\rannepu\\Documents\\TestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheetsCount=workbook.getNumberOfSheets();
		ArrayList<String> a=new ArrayList<String>();
		XSSFSheet worksheet = null;
		for(int i=0;i<sheetsCount;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("TestSheet"))
			{
				worksheet = workbook.getSheetAt(i);
				break;
			}
		}
		Iterator<Row> rows=worksheet.rowIterator();
		int column=0;
	    Row firstRow = rows.next();
	    Iterator<Cell> header = firstRow.cellIterator();
		while(header.hasNext())
		{
			Cell headercell = header.next();
			System.out.println("header"+headercell.getStringCellValue());
			if(headercell.getStringCellValue().equalsIgnoreCase("Data2"))
			{
				break;
			}
			column++;
		}
		Row row =null;
		while(rows.hasNext())
		{
			row = rows.next();
			System.out.println("Rows"+row.getCell(column).getStringCellValue());
			if(row.getCell(column).getStringCellValue().equalsIgnoreCase("Wrong"))
			{
				Iterator<Cell> matchedCell = row.cellIterator();
				while(matchedCell.hasNext())
				{
					Cell eachcell = matchedCell.next();
					if(eachcell.getCellType()!=CellType.STRING)
					{
						a.add(NumberToTextConverter.toText(eachcell.getNumericCellValue()));
					}
					else {
					a.add(eachcell.getStringCellValue());
					}
				}
				break;
			}
		}
		for(String s:a)
		{
			System.out.println(s);
		}

	}

	
}
