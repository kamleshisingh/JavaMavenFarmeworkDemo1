package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test1_GoogleSearch {
	public static void main(String[] args) {
		Test1_GoogleSearch ob = new Test1_GoogleSearch();
		ob.googleSearch();
	}
	public void googleSearch() 
	{
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		String driverPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",driverPath+"Drivers\\chromedriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://google.com/");
		
		driver.findElement(By.name("q")).sendKeys("automation");
		
//		driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
//		driver.findElement(By.name("btnK")).click();	
		
		driver.close();
		System.out.println("Test is succesull ");
	}

}
