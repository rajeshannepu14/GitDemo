package Learning2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actionsdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.partialLinkText("Conditions of Use")).click();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
        Actions a = new Actions(driver);
        WebElement move= driver.findElement(By.id("nav-link-accountList"));
        a.moveToElement(move).contextClick().build().perform();
        a.moveToElement(driver.findElement(By.id("nav-search-bar-form"))).click().
        keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
       
        
        
	}

}
