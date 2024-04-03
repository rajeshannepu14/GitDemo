package AutoIt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String downloadpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver1.exe");
		HashMap<String,Object> chromePrefs=new HashMap<String,Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadpath);
		ChromeOptions Options=new ChromeOptions();
		Options.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver = new ChromeDriver(Options);	
		driver.manage().window().maximize();
		driver.get("https://www.ilovepdf.com/pdf_to_jpg");
		
		driver.findElement(By.id("uploader")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\rannepu\\Documents\\AutoIt\\fileupload.exe");
		Thread.sleep(3000);
		driver.findElement(By.id("processTask")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		File f=new File(downloadpath+"/ilovepdf_pages-to-jpg.zip");
		if(f.exists())
		{
			Assert.assertTrue(f.exists());
			if(f.delete())
				System.out.println("file deleted");
		}
		
		driver.quit();
		
		

	}

}
