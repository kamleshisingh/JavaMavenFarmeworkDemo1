package test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver= null;
	public  void test1() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
	ChromeOptions co = new ChromeOptions();
	co.addArguments("--remote-allow-origins=*");
	System.setProperty("webdriver.chrome.driver", projectPath+"\\Drivers\\chromedriver\\chromedriver.exe");
	driver = new ChromeDriver(co);
	
	driver.get("https://google.com/");
	
	GoogleSearchPage.textBox_Search(driver).sendKeys("automation test enginer");
	Thread.sleep(2000);
	GoogleSearchPage.button_Search(driver).sendKeys(Keys.RETURN);
	driver.close();
	System.out.println("test iis successfull");
	}
	public static void main(String[] args) throws InterruptedException {
		GoogleSearchTest t = new GoogleSearchTest();
		t.test1();
	}

}
