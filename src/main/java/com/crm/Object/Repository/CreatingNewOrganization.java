package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodesk.genricutility.WebDriverUtility;

public class CreatingNewOrganization extends WebDriverUtility {// create class for every webPage
	// decleration
	@FindBy(name = "accountname")
	private WebElement orgName;

	@FindBy(name = "industry")
	private WebElement industry;

	@FindBy(name = "accounttype")
	private WebElement type;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveButton;

//Initionalization
	public CreatingNewOrganization(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

//Business Liberies
	public void sendDataToOrgName(String oName) {
		orgName.sendKeys(oName);
	}
	
	public void selectIndustry(String value) {
		select(industry, value);
	}
	
	public void selectType(String value) {
		select(type, value);
	}
	
	public void clickSave() {
		saveButton.click();
	}

}
