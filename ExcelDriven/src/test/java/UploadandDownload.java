import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadandDownload extends ColumnValue{

	@Test
	public void Upload() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		String text="Apple";
		String updatedValue = "800";
		String fileName="C:\\Users\\rannepu\\Downloads\\download.xlsx";
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.findElement(By.id("downloadButton")).click();
		//edit excel
		int col =getColumnNumber(fileName,"price");
		int row = getRowNumber(fileName,"Apple");
		Assert.assertTrue(updateCell(fileName,row,col,updatedValue));
		
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("C:\\Users\\rannepu\\Downloads\\download.xlsx");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));
		String toastmsg=driver.findElement(By.cssSelector(".Toastify__toast-body div:nth-child(2)")).getText();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".Toastify__toast-body"))));
		System.out.println(toastmsg);
		Assert.assertEquals(toastmsg,"Updated Excel Data Successfully.");
		String pricecol=driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		String actualvalue =driver.findElement(By.xpath("//div[text()='"+text+"']/parent::div/parent::div//div[@id='cell-"+pricecol+"-undefined']")).getText();
		System.out.println(actualvalue);
	}
}
