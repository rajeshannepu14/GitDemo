package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)");
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		System.out.println(rows.size());
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display th"));
		System.out.println(columns.size());
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(1)")).getText());
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(2)")).getText());
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3) td:nth-child(3)")).getText());

	}

}
