package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.WebDriverUtility;

public class HomePage extends WebDriverUtility { // create class gor every webpage

// Decleration
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organisatinBtn;

	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactBtn;

	@FindBy(xpath = "//a[@href='index.php?module=Potentials&action=index']")
	private WebElement opportunitiesBtn;

	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productsBtn;

	@FindBy(xpath = "//a[@href='index.php?module=Documents&action=index']")
	private WebElement documentBtn;

	@FindBy(xpath = "//a[@href='index.php?module=Emails&action=index']")
	private WebElement emailBtn;

	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement troubleTickets;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrationImg;

	@FindBy(xpath = "//a[contains(.,'Sign Out')]")
	private WebElement logout;

	// initilization using constructor
	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

// declerations
	
	public WebElement getOrganisatinBtn() {
		return organisatinBtn;
	}

	public WebElement getContactBtn() {
		return contactBtn;
	}

	public WebElement getOpportunitiesBtn() {
		return opportunitiesBtn;
	}

	public WebElement getProductsBtn() {
		return productsBtn;
	}

	public WebElement getDocumentBtn() {
		return documentBtn;
	}

	public WebElement getEmailBtn() {
		return emailBtn;
	}

	public WebElement getTroubleTickets() {
		return troubleTickets;
	}

	public WebElement getAdministrationImg() {
		return administrationImg;
	}

	public WebElement getLogout() {
		return logout;
	}
	
	// business Libaeries
	//1
	public void clikOnOrgnaisation() {
		organisatinBtn.click();
	}
	//2
	public void clikOnContact() {
		contactBtn.click();
	}
	//3
	public void clickOnOpportunities() {
		opportunitiesBtn.click();
	}
public void LogOut(WebDriver driver) {
	WebDriverUtility wlib = new WebDriverUtility();
	wlib.mouseOverOnWebElemnt(driver, administrationImg);
	logout.click();
}

	
}
