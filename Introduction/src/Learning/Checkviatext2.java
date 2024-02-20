package Learning;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkviatext2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		String[] itemsNeeded = { "Cucumber", "Beetroot", "Carrot" };
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
