package Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		List<WebElement> elementlist = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(originallist, sortedlist);
		//Assert.assertTrue(originallist.equals(sortedlist));
		
		List<String> veggie;
		do {
		List<WebElement> elementlist1 = driver.findElements(By.xpath("//tr/td[1]"));
		veggie= elementlist1.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList());
		veggie.forEach(a->System.out.println(a));
		if(veggie.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		}
		}while(veggie.size()<1);
	
		

	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String price=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		//System.out.println(price);
		return price;
	}
	
	
	

}
