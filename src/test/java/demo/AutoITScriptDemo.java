package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoITScriptDemo {
	@Test
	public void test()throws Exception {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://www.filemail.com/share/upload-file");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[text()='Add Files']")).click();
		String [] fileloc = {"D:\\FileUploadScript.au3"};
		Runtime.getRuntime().exec(fileloc);
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
