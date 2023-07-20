package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class ExcelDataProvider {
	static ExcelUtility excel;
	private static WebDriver driver;
 

//	public static void main(String[] args) {
//		getTestData();
//	}
	@BeforeTest
	public void setUpTest() throws InterruptedException
	{
		String projectPath = System.getProperty("user.dir");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver(co);
		
	}
	
	@Test(dataProvider = "testData")
	public void test1(String username,String password) throws InterruptedException {
		System.out.println(username+"  "+password);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@type='submit']")).sendKeys(Keys.RETURN);
		
	}
	
	@DataProvider(name="testData")
	public static Object[][] getData(){
		
		Object [][] data = getTestData();
		return data;
	}
	
	public static Object[][] getTestData() {
		String excelPath="D:/eclips/SeleniumMavenFramework_Demo/ExcelFile/Data.xlsx"; 
		excel = new ExcelUtility(excelPath, "Sheet1");
		
		
		int rowCount = excel.getRowCount();		
		int cellCount = excel.getCellCount(0);
		
		Object [][] data = new Object[rowCount-1][cellCount];
		
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				
				data[i-1][j]= excel.getValueFromExcel(i, j);
					
			}
			System.out.println();
		}
		return data;

	}

}
