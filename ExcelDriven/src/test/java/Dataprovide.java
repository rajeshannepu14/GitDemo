import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovide {

	@Test(dataProvider="gotData")
	public void testcaseData(String greeting,String communication,String number)
	{
		System.out.println(greeting+communication+number);
	}
	
	@DataProvider
	public Object[][] gotData() throws IOException
	{
		//Object[][] data= {{"Hello","Text",1},{"Hi","Message",2},{"Bye","Send",999}};
		DataFormatter formatter=new DataFormatter();
		FileInputStream fis=new FileInputStream("C:\\Users\\rannepu\\Documents\\TestData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowscount=sheet.getPhysicalNumberOfRows();
		System.out.println(rowscount+"no.of rows");
		XSSFRow row = sheet.getRow(0);
		int colcount=row.getLastCellNum();
		System.out.println(colcount+"no.of columns");
		Object data[][]=new Object[rowscount-1][colcount];
		for(int i=0;i<rowscount-1;i++)
		{
			row=sheet.getRow(i+1);
			for(int j=0;j<colcount;j++)
			{
				
				XSSFCell cell = row.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
				
			}
		}
		return data;
	}
}
