package demo;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgMultiBrowser {
	WebDriver driver;
	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		String projectPath=System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		
		
		System.out.println("your browser is "+browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver(co);
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver..driver", projectPath+"/Drivers/geckoDriver/geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", projectPath+"/Drivers/edgeDriver/msedgedriver.exe");
			driver = new EdgeDriver();
			
		}
		else {
			System.out.println("please selece the right browsername");
		}
		
		
	}
	@Test
	public void test1() throws InterruptedException {
		Thread.sleep(4000);
		driver.get("https://google.co.in");
	}
	
	@AfterTest
	public void tearDown() {
		
	}
}
