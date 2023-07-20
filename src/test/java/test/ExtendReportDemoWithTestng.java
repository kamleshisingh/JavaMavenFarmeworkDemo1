package test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportDemoWithTestng {
	private static WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	@BeforeSuite
	public void setUp() {
		 htmlReporter = new ExtentHtmlReporter("extendReport.html");
		 extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		
		
	}
	@BeforeTest
	public void settingUpWebDriver() 
	{
		String path = System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", path+"//Drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver(co);
	}
	
	
	@Test(priority = 0)
	public void testMethod() throws Exception {
		 test = extent.createTest("mytest","this the first test");
		test.log(Status.INFO,  "status of the browser");
		
		driver.get("https://google.co.in");
		test.pass("navigate the google.com");
		
		driver.findElement(By.name("q")).sendKeys("abcd");
		test.pass("put input on inputbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("press the enter");
		
		test.info("this is the test method ");
		test.pass("detail",MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");
			
	}
	
	@AfterTest
	public void closeingBrowser() {
		driver.quit();
		test.pass("closeing the driver");
	}
	@AfterSuite
	public void tearDown() {
		
		extent.flush();	
	}
}
