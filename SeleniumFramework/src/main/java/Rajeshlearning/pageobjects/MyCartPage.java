package Rajeshlearning.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Rajeshlearning.AbstractComponents.AbstractComponent;

public class MyCartPage extends AbstractComponent {

	WebDriver driver;
	public MyCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartlist;
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	public List<WebElement> listOfItemsInCart()
	{
		return cartlist;
	}
	
	public Boolean checkCorrectItemAdded(String name)
	{
		Boolean flag=cartlist.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
		return flag;
		
	}
	public void checkout()
	{
		
		checkout.click();
	}

}
