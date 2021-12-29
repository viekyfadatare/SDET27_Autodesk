package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {// create new class for WebPAge

	// decleration

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganisationLookup;

	@FindBy(name = "search_text")
	private WebElement searchFor;

	@FindBy(name = "submit")
	private WebElement searchNow;


	// initionlization

	public OrganisationPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

//Utilization
	public WebElement getCreateOrganisationLookup() {
		return createOrganisationLookup;
	}

	
	

	public WebElement getSearchFor() {
		return searchFor;
	}

	public WebElement getSearchNow() {
		return searchNow;
	}

	// BUsiness Liberies

	public void clickCreateOrganisationLookup() {
		createOrganisationLookup.click();
	}

	public void sendOrgnameToSearchFor(String orgName) {
		searchFor.sendKeys(orgName);
	}

	public void clickOnSearchNow() {
		searchNow.click();
	}

}
