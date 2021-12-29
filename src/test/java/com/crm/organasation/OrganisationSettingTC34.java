package com.crm.organasation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;

public class OrganisationSettingTC34 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		/*
		 * FileInputStream fis = new FileInputStream("./Data/commondata.properties");
		 * 
		 * Properties pro = new Properties(); pro.load(fis);
		 * 
		 * String URL = pro.getProperty("url"); String USERNAME =
		 * pro.getProperty("username"); String PASSWORD = pro.getProperty("password");
		 * String BROWAER = pro.getProperty("browser");
		 */

		FileUtility FUtil = new FileUtility();

		String URL = FUtil.getPropertyKeyValue("url");
		String USERNAME = FUtil.getPropertyKeyValue("username");
		String PASSWORD = FUtil.getPropertyKeyValue("password");
		String BROWAER = FUtil.getPropertyKeyValue("browser");
		WebDriver driver = new ChromeDriver();

		driver.get(URL);
		driver.manage().window().maximize();

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverUtility webut = new WebDriverUtility();
		
		webut.waitForPageToLoad(driver);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);

		driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);

		driver.findElement(By.xpath("(//a[contains(.,'Organizations')])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Organizations Settings']")).click();

		driver.close();

	}

}
