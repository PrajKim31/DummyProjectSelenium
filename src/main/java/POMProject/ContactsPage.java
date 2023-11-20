package POMProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage {

	// dropdown for title of name
	@FindBy(xpath = "(//span[@class='select2-arrow'])[1]")
	private WebElement droparrow;
	
	//searchbar for title
	@FindBy(id = "s2id_autogen2_search")
	private WebElement search;
	
	//firstname textfield
	@FindBy(name = "firstname")
	private WebElement fname;
	
	//lastname textfield
	@FindBy(name = "lastname")
	private WebElement lname;
	
	// Assigned to dropdown
	@FindBy(xpath = "(//span[@class='select2-arrow'])[3]")
	private WebElement assign;
	
	// searchbar for assigned to
	@FindBy(id = "s2id_autogen6_search")
	private WebElement searchassign;
	
	// save button
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement save;
	
	//signout option
	@FindBy(xpath = "//span[@class='fa fa-user']")
	private WebElement img;
	
	//signout button
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement logout;
	
	
	public WebElement getDroparrow() {
		return droparrow;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}
	
	public WebElement getAssign() {
		return assign;
	}

	public WebElement getSearchassign() {
		return searchassign;
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
