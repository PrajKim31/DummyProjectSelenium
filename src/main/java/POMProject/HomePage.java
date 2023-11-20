package POMProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	//menu option
	@FindBy(xpath = "(//span[@class='app-icon fa fa-bars'])[1]")
	private WebElement menu;
	
	//marketing option
	@FindBy(xpath = "//span[text()=' MARKETING']")
	private WebElement marketing;
	
	//organization option
	@FindBy(xpath = "(//span[text()=' Organizations'])[1]")
	private WebElement organization;
	
	//contacts option
	@FindBy(xpath = "(//span[text()=' Contacts'])[1]")
	private WebElement contacts;
	
	//add organization button
	@FindBy(id = "Accounts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addorg;

	//add contacts buttonq
	@FindBy(id = "Contacts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addcont;
	
	public WebElement getMenu() {
		return menu;
	}

	public WebElement getMarketing() {
		return marketing;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getAddorg() {
		return addorg;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getAddcont() {
		return addcont;
	}
	
	
	

	
	
	
	
	

}
