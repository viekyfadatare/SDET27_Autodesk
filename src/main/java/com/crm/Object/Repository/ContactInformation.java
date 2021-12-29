package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformation {// craete class for every webpage

	//decleration
	@FindBy(id = "dtlview_Last Name")
	private WebElement createdContact;
	
	// initionalization
	public ContactInformation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Utilization

	public WebElement getCreatedContact() {
		return createdContact;
	}
	
	// Bussiness Liberies
	public String getVerifycreatedContact() {
	
		return createdContact.getText();
	}
}

	
