package owa.qa.SeleniumTut;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import org.junit.Before;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;

public class ShoppingTest {

	
	WebDriver driver;
	@Before 
	public void setup() { 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\chromedriver.exe");	
		 driver =new ChromeDriver(); 
	}


	@After 
	public void teardown() { 
		driver.quit();
	}
    
	@Test
	public void Shopping() throws InterruptedException { 
	
		driver.get("http://automationpractice.com/index.php"); 
		Search Dress = PageFactory.initElements(driver, Search.class);	
		Dress.SearchDetails(Constants.DRESS); 
		Thread.sleep(3000);
		assertEquals("Search not successful", "Printed Summer Dress",  driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/h5/a")).getText());
		
}
	

	
	
}