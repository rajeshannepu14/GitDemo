package Rajeshlearning.tests;

import java.awt.Window;
import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class StandAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("Rajesh@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Rajesh123");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement>items=driver.findElements(By.cssSelector(".mb-3"));
		String name="ZARA COAT 3";
		WebElement cart = items.stream().filter(s->s.findElement(By.cssSelector("b")). getText().contains(name)).findFirst().orElse(null);
	    cart.findElement(By.cssSelector(".card-body button:last-of-type")).click();  
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	   // Thread.sleep(5000);
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	    List<WebElement> listitems = driver.findElements(By.cssSelector(".cartSection h3"));
	    boolean flag = listitems.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
	    Assert.assertTrue(flag);
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    /*
	    driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
	    List<WebElement> country = driver.findElements(By.cssSelector("button .ng-star-inserted"));
	    country.stream().filter(s->s.getText().equalsIgnoreCase("India")).limit(1).forEach(s->s.click());
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    */
	    Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,200)");
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));
		WebElement placeorder = driver.findElement(By.cssSelector(".action__submit"));
		js.executeScript("arguments[0].click();",  placeorder);
		String Actualmsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(Actualmsg);
		Assert.assertTrue(Actualmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		 
	}

}
