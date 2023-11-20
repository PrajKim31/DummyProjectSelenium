package POMProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage {
	
	//organization text field 
	@FindBy(name = "accountname")
	private WebElement orgnametf;
	
	// assigned to dropdown
	@FindBy(xpath = "(//span[@role='presentation'])[4]")
	private WebElement assignedto;

	//search field
	@FindBy(id = "s2id_autogen8_search")
	private WebElement market;
	
	// save button
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;
	
	// signout image
	@FindBy(xpath = "//span[@class='fa fa-user']")
	private WebElement img;
	
	//signout button
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logout;
	

	public WebElement getOrgnametf() {
		return orgnametf;
	}


	public WebElement getAssignedto() {
		return assignedto;
	}
	
	public WebElement getMarket() {
		return market;
	}


	public WebElement getSave() {
		return save;
	}


	public WebElement getImg() {
		return img;
	}


	public WebElement getLogout() {
		return logout;
	}
	
	
	
	
	

}
