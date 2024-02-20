package LearningTestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	@BeforeClass
	public void Beforeclass()
	{
		System.out.println("Execute before the class");
	}
	@AfterClass
	public void Afterclass()
	{
		System.out.println("Execute after the class");
	}
	@Test
	public void Webhomeloanlogin()
	{
		System.out.println("Hellohomelogin");
	}
	@Parameters({"URL"})
	@Test()
	public void Mobilehomelogin(String uname)
	{
		System.out.println("Mobilehomelogin");
		System.out.println(uname);
	}
	@Parameters({"URL","Key"})
	@Test
	public void Mobilehomeurl(String uname,String key)
	{
		System.out.println("Mobilehomeurl");
		System.out.println(uname);
		System.out.println(key);
	}
	@Test(dependsOnMethods= {"Webhomeloanlogin","Mobilehomelogin"})
	public void Mobilehomesignout()
	{
		System.out.println("Mobilehomesignout");
	}
	@BeforeTest
	public void Mobilehomesignin()
	{
		System.out.println("Mobilehomesignin");
	}
	@AfterTest
	public void Mobilehomelogout()
	{
		System.out.println("Mobilehomelogout");
	}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("I will execute after test");
	}
	@BeforeMethod
	public void Beforemethod()
	{
		System.out.println("I will execute before test");
	}
	@AfterSuite
	public void Atersuit()
	{
		System.out.println("I will execute last");
	}
	@Test(groups= {"Smoke"})
	public void Apihomelogin()
	{
		System.out.println("APIhomelogin");
	}

}
