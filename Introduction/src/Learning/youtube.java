package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class youtube {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("#search-input #search")).sendKeys("Cricket");
		driver.findElement(By.cssSelector("#search-icon-legacy .yt-icon")).click();
		
	}

}
