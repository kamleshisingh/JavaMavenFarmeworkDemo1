package DefaultPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {


	public static void main(String[] args) throws Exception {

		String path = System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");

		DesiredCapabilities dCaps = new DesiredCapabilities();
		dCaps.setCapability("ignoreProtectedModeSettings", true);

		System.setProperty("webdriver.edge.driver", path+"//Drivers//edgeDriver//msedgedriver.exe");
		WebDriver driver = new EdgeDriver(Caps);

		driver.get("https://google.co.in");

		driver.findElement(By.name("q")).sendKeys("abcd");
		//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		driver.findElement(By.name("btnK")).click();

		driver.quit();

		System.out.println("test is done!");


	}

}
