package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)

public class TestNgListeners_Demo {
	WebDriver driver;
	@Test
	public void test1() {
		System.out.println("i am inside test1");
	}
	@Test
	public void test2() {
		System.out.println("i am inside test2");
		String projectPath = System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
		
		System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver(co);
		driver.get("https://google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Test ng listner methds");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.quit();
		
	}
	@Test
	public void test3() {
		System.out.println("i am inside test3");
//		throw new SkipException("this test is skiped ");
	}
	@Test
	public void test4() {
		System.out.println("i am inside test4");
	}
}
