package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkviatext {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		String[] itemsNeeded= {"Cucumber - 1 Kg","Brocolli - 1 Kg","Beetroot - 1 Kg"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		for(String s:itemsNeeded)
		{
		driver.findElement(By.xpath("//h4[text()='"+s+"']/parent::div//button")).click();
		
		}

	}

}
