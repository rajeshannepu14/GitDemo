package Learning;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//ChromeOptions opt= new ChromeOptions();
		//opt.addExtensions(new File("./Extensions/AdBlock.crx"));
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
		driver.findElement(By.cssSelector(".close")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector(".searchCity")).click();
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		driver.findElement(By.cssSelector(".searchToCity")).click();
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();

	}
	
}
