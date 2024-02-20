package Rajeshlearning.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rajeshlearning.AbstractComponents.AbstractComponent;



public class ProductCatalogue extends AbstractComponent {
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
	List<WebElement> product;
	@FindBy(css=".ng-animating")
	WebElement animating;
	
	By productBy=By.cssSelector(".mb-3");
	By cart=By.cssSelector(".card-body button:last-of-type");
	By toastmsg= By.cssSelector("#toast-container");
	public List<WebElement> listOfItems()
	{
		waitForElementToAppear(productBy);
		return product;
	}
	
	public WebElement selectItemlocationbyname(String name)
	{
		WebElement prod = product.stream().filter(s->s.findElement(By.cssSelector("b")). getText().contains(name)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addToCart(String name) throws InterruptedException
	{
		WebElement prod = selectItemlocationbyname(name);
		prod.findElement(cart).click();
		waitForElementToAppear(toastmsg);
		Thread.sleep(1000);
					
	}
	
	

}
