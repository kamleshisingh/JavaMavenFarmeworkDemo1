package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.GoogleSearchPageObject;

public class GoogleSearchPageObjectTest {
	private static WebDriver driver;
	public static void test() {
		String projectPath=System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(co);
		
		GoogleSearchPageObject ob = new GoogleSearchPageObject(driver);
		driver.get("https://google.co.in");
		ob.setSearchBoxInput("A B C D");
		ob.clickOnSearch();
		driver.quit();
		System.out.println("Test id done !!!");
		
	}
	public static void main(String[] args) {
		test();
	}

}
