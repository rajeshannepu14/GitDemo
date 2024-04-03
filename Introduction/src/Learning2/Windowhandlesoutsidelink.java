package Learning2;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandlesoutsidelink {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//tab or window same syntax just change .TAB for window
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.get("https://rahulshettyacademy.com/");
		String name=driver.findElements(By.cssSelector("div[class='upper-box'] h2")).get(0).getText();
		driver.switchTo().window(parentId);
		WebElement nameid = driver.findElement(By.name("name"));
		nameid.sendKeys(name);
		File file = nameid.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("happy.png"));
		System.out.println(nameid.getRect().getDimension().getHeight());
		System.out.println(nameid.getRect().getDimension().getWidth());
		

	}

}
