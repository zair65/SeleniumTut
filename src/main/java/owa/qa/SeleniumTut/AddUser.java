package owa.qa.SeleniumTut;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	public class AddUser {

		
		@FindBy(name="username") 
		private WebElement User; 
		
		@FindBy(name="password") 
		private WebElement Pass; 
		
		@FindBy(name="FormsButton2")
		private WebElement Submit; 

		
		
		public void AddUserDetails(String username, String password)  { 
			User.sendKeys(username);
			Pass.sendKeys(password);
			Submit.click(); 
		
		}



		
		
	}

