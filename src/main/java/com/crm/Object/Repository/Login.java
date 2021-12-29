package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author admin
 *
 */
public class Login { // crreate seprate class for every webpage

	// declearation
	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passWordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

// Initialization us construnctor
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

//utilization using getters method 

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// business Libaeries
	public void login(String username , String password) {
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	}

}
