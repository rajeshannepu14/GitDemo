package Rajeshlearning.tests;

import java.awt.Window;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import Rajeshlearning.TestComponents.BaseTest;
import Rajeshlearning.pageobjects.CheckoutPage;
import Rajeshlearning.pageobjects.LandingPage;
import Rajeshlearning.pageobjects.MyCartPage;
import Rajeshlearning.pageobjects.OrdersPage;
import Rajeshlearning.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {
	String name = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrder(HashMap<String,String>input) throws IOException, InterruptedException {
		
		ProductCatalogue productcatalogue = landingpage.loginDetails(input.get("email"),input.get("pwd"));
		List<WebElement> productslist = productcatalogue.listOfItems();
		productcatalogue.addToCart(input.get("prodname"));
		MyCartPage mycartpage = productcatalogue.goToCart();
		Boolean flag = mycartpage.checkCorrectItemAdded(input.get("prodname"));
		Assert.assertTrue(flag);
		mycartpage.checkout();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		checkoutpage.selectCountry();
		checkoutpage.placeOrder();
		String Actualmsg = checkoutpage.orderConfirmation();
		System.out.println(Actualmsg);
		Assert.assertTrue(Actualmsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	
	@Test(dependsOnMethods={"submitOrder"})
	public void orderHistoryTest()
	{
		ProductCatalogue productcatalogue = landingpage.loginDetails("Rajesh@gmail.com", "Rajesh123");
		OrdersPage orderspage = productcatalogue.goToOrders();
		Boolean flag = orderspage.checkCorrectItemAdded(name);
		Assert.assertTrue(flag);
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		/*HashMap<String,String> map= new HashMap<String,String>();
		map.put("email", "Rajesh@gmail.com");
		map.put("pwd", "Rajesh123");
		map.put("prodname", "ZARA COAT 3");
		HashMap<String,String> map1= new HashMap<String,String>();
		map1.put("email", "SaiRam@gmail.com");
		map1.put("pwd", "Sai@1234");
		map1.put("prodname", "ADIDAS ORIGINAL");*/
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Rajeshlearning\\data\\PurchaseOrder.json");
		return new Object[][] { {data.get(0)}, {data.get(1)} };
	}

}
