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
	public void User() throws InterruptedException { 
	
		driver.get("http://thedemosite.co.uk/addauser.php"); 
		AddUser UserTest1 = PageFactory.initElements(driver, AddUser.class);
		Thread.sleep(5000);
		UserTest1.AddUserDetails(Constants.USER, Constants.PASS);  
		driver.get("http://thedemosite.co.uk/login.php"); 
		Thread.sleep(3000);
		UserTest1.AddUserDetails(Constants.USER, Constants.PASS);
		assertEquals("login was not successful", "**Successful Login**",  driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
		
}
	

	
	
}