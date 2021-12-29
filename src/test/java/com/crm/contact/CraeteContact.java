package com.crm.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Object.Repository.ContactPage;
import com.crm.Object.Repository.CreateNewContactPage;
import com.crm.Object.Repository.HomePage;
import com.crm.autodesk.genricutility.BaseClass;

@Listeners(com.crm.autodesk.genricutility.ListnerImplementation.class)
public class CraeteContact extends BaseClass {

	// public static void main(String[] args) throws Throwable {
	// TODO Auto-generated method stub

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
	 * 
	 * WebDriver driver;
	 * 
	 * if(BROWSER.equals("chrome")) { driver = new ChromeDriver(); }else { driver =
	 * new FirefoxDriver();
	 * 
	 * }
	 * 
	 * driver.get(URL);
	 * 
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 */

	/*
	 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);
	 * 
	 * driver.findElement(By.linkText("Contacts")).click();
	 * driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	 * WebElement lname = driver.findElement(By.name("lastname"));
	 * 
	 * 
	 * FileInputStream f = new FileInputStream("./Data/orgnasation.xlsx");
	 * 
	 * Workbook wb = WorkbookFactory.create(f);
	 * 
	 * Sheet sh = wb.getSheet("org");
	 * 
	 * Cell cel = sh.getRow(1).getCell(5);
	 * 
	 * String ln = cel.getStringCellValue();
	 * 
	 * Random ran = new Random();
	 * 
	 * int ranNo = ran.nextInt(1000);
	 * 
	 * lname.sendKeys(ln+ranNo);
	 * 
	 * driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	 * 
	 * WebElement sout = driver.findElement(By.
	 * xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
	 * 
	 * Actions a = new Actions(driver); a.moveToElement(sout).perform();
	 * 
	 * System.out.println(driver.findElement(By.xpath(
	 * "//span[@class='dvHeaderText']")).getText());
	 * 
	 * driver.findElement(By.linkText("Sign Out")).click();
	 * 
	 * Thread.sleep(5000);
	 * 
	 * // driver.close();
	 */

	@Test(groups = "smokesuite")

	public void CreateContact() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.clikOnContact();
		ContactPage cp = new ContactPage(driver);
		cp.clickOncreateContactLoolUp();
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		String lname = elib.getDataFromExcelSheet("contact", 1, 2) + jlib.getRandomNumber();
		cnp.sendDataToLastName(lname);
		// Assert.fail();
		cnp.clickOnSave(driver, lname);
	}
}
