package Rajeshlearning.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Rajeshlearning.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingpage;
	public void initializeDrivers() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Rajeshlearning\\resources\\GlobalData.properties");
		prop.load(fis);
		String webbrowsername=System.getProperty("browser")!= null ? System.getProperty("browser"):prop.getProperty("browser");
		
		if(webbrowsername.contains("chrome"))
		{
			ChromeOptions options= new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(webbrowsername.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
			//driver.manage().window().setSize(new Dimension(1440,900));//for full size window
		}
		else if(webbrowsername.equalsIgnoreCase("firefox"))
		{
			//firefox
		}
		else if(webbrowsername.equalsIgnoreCase("edge"))
		{
			//edge
		}
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver= new ChromeDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//return driver;
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException
	{
		initializeDrivers();
		landingpage= new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
	}
	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.quit();
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException 
	{
		String jsoncontent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		return data;
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	}

	
	
}
