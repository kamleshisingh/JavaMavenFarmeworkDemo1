package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
	WebDriver driver;
	By textbox_Search = By.id("APjFqb");
	
	By button_Search = By.name("btnK");
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void setSearchBoxInput(String  text) {
		driver.findElement(textbox_Search).sendKeys(text);
		
	}
	public void clickOnSearch() {
		
		driver.findElement(button_Search).sendKeys(Keys.RETURN);
	}
	
	

}
