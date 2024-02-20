package Rajeshlearning.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rajeshlearning.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement Useremail;
	@FindBy(id="userPassword")
	WebElement Password;
	@FindBy(id="login")
	WebElement Login;
	@FindBy(css=".toast-message")
	WebElement Errorlogin;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(Errorlogin);
		return Errorlogin.getText();
	}
	
	public ProductCatalogue loginDetails(String email,String pwd)
	{
		Useremail.sendKeys(email);
		Password.sendKeys(pwd);
		Login.click();
		ProductCatalogue productcatalogue= new ProductCatalogue(driver);
		return productcatalogue;
	}
	

}
