package Rajeshlearning.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Rajeshlearning.pageobjects.MyCartPage;
import Rajeshlearning.pageobjects.OrdersPage;

public class AbstractComponent {
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(css="[routerlink*='cart']")
	WebElement gotocart;
	@FindBy(css="[routerlink*='myorders']")
	WebElement gotoorder;
	
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisappear(WebElement animating)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOf(animating));
	}
	
	public void ActionSendKeys(By action, String countryname)
	{
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(action), countryname).build().perform();
		
	}
	
	public void Javascriptclick(WebElement placeorder)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",  placeorder);
	}
	
	public MyCartPage goToCart()
	{
		gotocart.click();
		MyCartPage mycartpage= new MyCartPage(driver);
		return mycartpage;
	}
	
	public OrdersPage goToOrders()
	{
		gotoorder.click();
		OrdersPage orderspage= new OrdersPage(driver);
		return orderspage;
	}

}
