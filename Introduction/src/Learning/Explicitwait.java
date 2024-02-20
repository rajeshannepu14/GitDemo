package Learning;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicitwait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsNeeded = { "Cucumber", "Beetroot", "Carrot" };
		Explicitwait obj= new Explicitwait();
		obj.add(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
	    System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}
	public void add(WebDriver driver, String[] itemsNeeded)
	{
		List<WebElement> names = driver.findElements(By.cssSelector("h4.product-name"));
		List itemsNeededList = Arrays.asList(itemsNeeded);
		int j = 0;
		for (int i = 0; i < names.size(); i++) {
			String[] formattednames = names.get(i).getText().split("-");
			String formattedname = formattednames[0].trim();
			System.out.println(formattedname);
			if (itemsNeededList.contains(formattedname)) {
				driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
				j++;
			}
			if (j == itemsNeeded.length) {
				break;
			}
		}
	}

}
