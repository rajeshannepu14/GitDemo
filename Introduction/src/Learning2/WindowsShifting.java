package Learning2;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsShifting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String Parentid=it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		System.out.println(driver.findElement(By.partialLinkText("mentor@rahulshettyacademy.com")).getText());
		String username = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(Parentid);
		driver.findElement(By.id("username")).sendKeys(username);
		
		
	}

}
