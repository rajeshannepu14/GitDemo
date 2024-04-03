package Chromefeatues;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetGeoLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		HashMap<String,Object> coordinates=new HashMap<String,Object>();
		coordinates.put("latitude",35);
		coordinates.put("longitude",6);
		coordinates.put("accuracy",1);
		
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", coordinates);
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Netflix",Keys.ENTER);
		


	}

}
