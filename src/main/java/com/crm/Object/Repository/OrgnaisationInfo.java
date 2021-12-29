package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnaisationInfo {// create class fo every web Page

	// delcleration

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgInfo;

	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement createdOrg;

	// initionlization
	public OrgnaisationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilisation
	public WebElement getOrgInfo() {
		return orgInfo;
	}

	public WebElement getCreatedOrg() {
		return createdOrg;
	}

	// Businness Lyberies
	public String getVerifyOrgInfo() {
		return (orgInfo.getText());
	}

	public String storeCreatedOrg() {
		return createdOrg.getText();
	}

}
