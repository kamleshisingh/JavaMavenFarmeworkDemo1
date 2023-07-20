package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportBasicDemo {
	static private WebDriver driver;
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extend.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("google search box" ,"this is a test for validating google serach box");
		
		String path = System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", path+"//Drivers//chromedriver//chromedriver.exe");
		driver = new ChromeDriver(co);
		test1.log(Status.INFO, "Starting test case");
		
		driver .get("https://google.co.in");
		test1.pass("navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("abcd");
		test1.pass("enter input to the text box");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("pressing the enter key from the keyboard");
		
		driver.close();
		test1.pass("the browser is closeing ");
		driver.quit();
		
		test1.info("test completed ");
		
		extent.flush();
	}

}
