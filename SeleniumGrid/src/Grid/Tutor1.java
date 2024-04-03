package Grid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Tutor1 {

	@Test
	public void Demo1() throws MalformedURLException, URISyntaxException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		//cap.setPlatform(Platform.);
		//cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		WebDriver driver=new RemoteWebDriver(new URI("http://192.168.29.251:4444").toURL(),cap);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("Q")).sendKeys("Rajesh");
		driver.close();
	}
}
