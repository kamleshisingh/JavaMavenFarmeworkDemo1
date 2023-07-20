package test;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFiles;

public class TestNg_Demo {
	private static WebDriver driver ;
	PropertiesFiles ob = new PropertiesFiles();
	public static String browserName =PropertiesFiles.getPropertyFileData("browser");
			
	@BeforeTest
	public void setUpTest() throws InterruptedException
	{
		
		String projectPath = System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		if(browserName.equalsIgnoreCase("chrome")) 
		{
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(co);
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\geckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}
	@Test
	public void TestMeth() throws InterruptedException{
		driver.get("https://google.co.in");
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys("A B C D");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	@AfterTest
	public void closeingMeth() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.close();
		PropertiesFiles.setPropertyFile("result", "pass");
//		System.out.println("test: "+PropertiesFiles.getPropertyFileData("test"));
		
		System.out.println("Test in done !!!!");
	}

}
