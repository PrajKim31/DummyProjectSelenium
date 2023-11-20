package POMProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

		//submit button click
		@FindBy(xpath = "//button[text()='Sign in']")
		private WebElement submitbtn;

		public WebElement getSubmitbtn() {
			return submitbtn;
		}
		
		

}


