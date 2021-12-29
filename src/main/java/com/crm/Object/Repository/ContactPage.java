package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {// craete class for every webPage
	// decleration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLoolUp;

	@FindBy(name = "search_text")
	private WebElement searchfor;

	@FindBy(name = "submit")
	private WebElement SerchNow;

	// Initialzation

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization

	public WebElement getCreateContactLoolUp() {
		return createContactLoolUp;
	}

	public WebElement getSearchfor() {
		return searchfor;
	}

	public WebElement getSerchNow() {
		return SerchNow;
	}
	
	//BusinnessLibery
	
	public void clickOncreateContactLoolUp() {
		createContactLoolUp.click();
	}
	
	public void addDataToSearchfor(String contactName ) {
		searchfor.sendKeys(contactName);
	}
	
	public void clickOnSearch() {
		SerchNow.click();
	}
	
}
