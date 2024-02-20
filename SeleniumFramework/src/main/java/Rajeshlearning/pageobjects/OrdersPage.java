package Rajeshlearning.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Rajeshlearning.AbstractComponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {

	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderslist;
	
	
	
	public Boolean checkCorrectItemAdded(String name)
	{
		Boolean flag=orderslist.stream().anyMatch(s->s.getText().equalsIgnoreCase(name));
		return flag;
		
	}

}
