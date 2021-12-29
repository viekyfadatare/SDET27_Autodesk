package com.crm.organasation;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;

public class OrgnisatiuonFindDuplicateTestCase33 {

	public static void main(String[] args) throws Throwable {

		/*
		 * FileInputStream fis = new FileInputStream("./Data/commondata.properties");
		 * 
		 * Properties pro = new Properties();
		 * 
		 * pro.load(fis);
		 * 
		 * String URL = pro.getProperty("url"); String USERNAME =
		 * pro.getProperty("username"); String PASSWORD = pro.getProperty("password");
		 * String BROWSER = pro.getProperty("browser");
		 */

		FileUtility FUtil = new FileUtility();

		String URL = FUtil.getPropertyKeyValue("url");
		String USERNAME = FUtil.getPropertyKeyValue("username");
		String PASSWORD = FUtil.getPropertyKeyValue("password");
		String BROWSER = FUtil.getPropertyKeyValue("browser");

		WebDriver driver = new ChromeDriver();

		driver.get(URL);
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebDriverUtility webut = new WebDriverUtility();
		webut.waitForPageToLoad(driver);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@title='Find Duplicates']")).click();

		driver.findElement(By.xpath("//select[@id='availList']/option[contains(.,'Organization Name')]")).click();

		driver.findElement(By.xpath("(//input[@class='crmButton small'])[1]")).click();

		driver.findElement(By.name("save&merge")).click();

		WebElement sout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		webut.mouseOverOnWebElemnt(driver, sout);

		WebElement signout = driver.findElement(By.xpath("//a[contains(.,'Sign Out')]"));

		webut.waitAndClick(signout);

		Thread.sleep(3000);
		driver.close();

	}

}
