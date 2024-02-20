package Rajeshlearning.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Rajeshlearning.TestComponents.BaseTest;
import Rajeshlearning.pageobjects.CheckoutPage;
import Rajeshlearning.pageobjects.LandingPage;
import Rajeshlearning.pageobjects.MyCartPage;
import Rajeshlearning.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefintion extends BaseTest{
	LandingPage landingpage;
	ProductCatalogue productcatalogue;
	MyCartPage mycartpage;
	CheckoutPage checkoutpage;
	@Given("Landed on Ecommerce Page")
	public void Landed_on_Ecommerce_Page() throws IOException
	{
		landingpage=launchApplication();
	}
	@Given("^Login with Username (.+) and Password (.+)$")
	public void Login_with_Username_and_Password(String userName, String password)
	{
		productcatalogue = landingpage.loginDetails(userName,password);
	}
	@When("^Add product (.+) to cart$")
	public void Add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> productslist = productcatalogue.listOfItems();
		productcatalogue.addToCart(productName);
	}
	@When("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName)
	{
		mycartpage = productcatalogue.goToCart();
		Boolean flag = mycartpage.checkCorrectItemAdded(productName);
		Assert.assertTrue(flag);
		mycartpage.checkout();
	    checkoutpage = new CheckoutPage(driver);
		checkoutpage.selectCountry();
		checkoutpage.placeOrder();
	}
	@Then("{string} message is displayed on the Confirmatio Page")
	public void message_is_displayed_on_the_Confirmation_Page(String string)
	{
		String Actualmsg = checkoutpage.orderConfirmation();
		System.out.println(Actualmsg);
		Assert.assertTrue(Actualmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string, landingpage.getErrorMessage());
	}

	
	
}
