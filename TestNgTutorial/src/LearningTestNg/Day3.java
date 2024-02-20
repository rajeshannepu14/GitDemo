package LearningTestNg;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day3 {
	
	@AfterTest
	public void Webcarloanlogin()
	{
		System.out.println("Hellocarlogin");
	}
	@Test(groups= {"Smoke"})
	public void Mobilecarlogin()
	{
		System.out.println("Mobilecarlogin");
	}
	@Test(dataProvider="getdata")
	public void Mobilecarsignin(String uname, String pwd)
	{
		System.out.println("Mobilecarsignin");
		System.out.println(uname);
		System.out.println(pwd);
	}
	@Test(enabled=false)
	public void Apicarlogin()
	{
		System.out.println("APIcarlogin");
	}
	@Test(timeOut=4000)
	public void Apicarlogout()
	{
		System.out.println("APIcarlogout");
		Assert.assertTrue(false);
	}
	@BeforeSuite
	public void beforesuite()
	{
		System.out.println("I will execute first");
	}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[3][2];
		data[0][0]="Firstusername";
		data[0][1]="Firstpwd";
		data[1][0]="Secondusername";
		data[1][1]="Secondpwd";
		data[2][0]="Thirdusername";
		data[2][1]="Thirdpwd";
		return data;
	}
	
}


