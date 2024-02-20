package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Ramu");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ramu@gmail.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Ramu@123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement Staticdropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown= new Select(Staticdropdown);
		dropdown.selectByIndex(0);
		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("23-08-1989");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
		
		
		
	}

}
