package Grid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Tutor2 {

	@Test
	public void Demo1() throws MalformedURLException, URISyntaxException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("edge");
		//cap.setPlatform(Platform.);
		//cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		//cap.setCapability(CapabilityType.BROWSER_NAME,"Edge");
		WebDriver driver=new RemoteWebDriver(new URI("http://192.168.29.251:4444").toURL(),cap);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
