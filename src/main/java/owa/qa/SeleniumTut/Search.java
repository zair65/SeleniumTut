package owa.qa.SeleniumTut;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


	public class Search {

		
		@FindBy(name="search_query") 
		private WebElement Query; 
		
		@FindBy(name="submit_search")
		private WebElement Submit; 

		
		
		public void SearchDetails(String Dress)  { 
			Query.sendKeys(Dress);
			Submit.click(); 
		
		}



		
		
	}

