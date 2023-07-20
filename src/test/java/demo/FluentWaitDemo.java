package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {
	static WebDriver driver;
	@Test
	public void test() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));

		driver.get("https://google.co.in");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='btnK']")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id='botstuff']/div/div[3]/table/tbody/tr/td[3]/a")).click();
		Thread.sleep(4000);
		/* .....Fluent wait........... */
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.

		WebElement ele = driver.findElement(By.linkText("ABCD Rhymes - Alphabet Songs for children - YouTube"));
		fluentWaitMeth(ele);

		driver.close();
	}

	public static WebElement fluentWaitMeth(WebElement ele) {
		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(driver -> {	return ele;});
		return foo;
	}

}
