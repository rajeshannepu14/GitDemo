package Rajeshlearning.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Rajeshlearning.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement country;
	@FindBy(css=".action__submit")
	WebElement placeorder;
	@FindBy(css=".hero-primary")
	WebElement orderconfirmationtext;
	
	By countrydropdownvisible = By.cssSelector(".ta-results");
	By action= By.cssSelector("[placeholder='Select Country']");
	
	public void selectCountry()
	{
		String countryname="India";
		ActionSendKeys(action,countryname);
		waitForElementToAppear(countrydropdownvisible);
		country.click();
	}
	
	public void placeOrder()
	{
		Javascriptclick(placeorder);
	}
	
	public String orderConfirmation()
	{
		String Actualmsg = orderconfirmationtext.getText();
		return Actualmsg;
		
	}
	
	

}
