package Rajeshlearning.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Rajeshlearning.TestComponents.BaseTest;
import Rajeshlearning.pageobjects.MyCartPage;
import Rajeshlearning.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {
	
	@Test(groups= {"Error handling"}, retryAnalyzer=Rajeshlearning.TestComponents.Retry.class)
	public void loginErrorValidation()
	{
	landingpage.loginDetails("Rajesh@gmail.com", "Rajesh1234");
	Assert.assertEquals("Incorrect email or password", landingpage.getErrorMessage());
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException
	{
		String name = "ZARA COAT 3";
		ProductCatalogue productcatalogue = landingpage.loginDetails("Rajesh@gmail.com", "Rajesh123");
		productcatalogue.listOfItems();
		productcatalogue.addToCart(name);
		MyCartPage mycartpage = productcatalogue.goToCart();
		Boolean flag = mycartpage.checkCorrectItemAdded("ZARA COAT 33");
		Assert.assertFalse(flag);
	}
	
	

}
