package Learning2;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chromeoption_SSL_Proxy_Popupblock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		ChromeOptions options= new ChromeOptions();
		//proxy
		/*Proxy proxy = new Proxy();

		proxy.setHttpProxy("ipaddress:4444");

		options.setCapability("proxy", proxy);

		Map<String, Object> prefs = new HashMap<String, Object>();



		prefs.put("download.default_directory", "/directory/path");



		options.setExperimentalOption("prefs", prefs);*/
		options.setAcceptInsecureCerts(true);
		System.setProperty("webdriver.chrome.driver", "C:/Users/rannepu/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);	
		driver.manage().window().maximize();
		driver.get("https://expired.badssl.com/");
		
		

	}

}
