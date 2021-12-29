package com.crm.Object.Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {// craete Pom FOr Every WebPage
	// decleration
	@FindBy(name = "lastname")
	private WebElement lastName;

	@FindBy(xpath = "(//img[@style='cursor:hand;cursor:pointer'])[1]")
	private WebElement OrgNameLookUp;

	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchBox;
	
	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	// Initionlization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrgNameLookUp() {
		return OrgNameLookUp;
	}

// business Liberies
	public void sendDataToLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void clickOneOrgNameLookUp() {
		OrgNameLookUp.click();
	}
	public void searchOrgName(WebDriver driver,String partialWin, String Oname) {
		switchToWindow(driver, partialWin);
		searchBox.sendKeys(Oname);
		searchBtn.click();
		driver.findElement(By.xpath("//a[contains(.,'"+Oname+"')]")).click();
	}
	public void clickOnSave(WebDriver driver,String partialWin) {
	
		switchToWindow(driver, partialWin);

		saveBtn.click();
	}
	
}
