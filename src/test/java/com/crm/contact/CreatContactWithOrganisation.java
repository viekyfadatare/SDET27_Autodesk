package com.crm.contact;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Object.Repository.ContactPage;
import com.crm.Object.Repository.CreateNewContactPage;
import com.crm.Object.Repository.CreatingNewOrganization;
import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.OrganisationPage;
import com.crm.Object.Repository.OrgnaisationInfo;
import com.crm.autodesk.genricutility.BaseClass;

public class CreatContactWithOrganisation extends BaseClass {

	/*
	 * public static void main(String[] args) throws Throwable { // TODO
	 * Auto-generated method stub
	 * 
	 * FileInputStream fis = new FileInputStream("./Data/commondata.properties");
	 * 
	 * Properties pro = new Properties();
	 * 
	 * pro.load(fis);
	 * 
	 * String URL = pro.getProperty("url"); String PASSWORD =
	 * pro.getProperty("password"); String USERNAME = pro.getProperty("username");
	 * String BROWSER = pro.getProperty("browser");
	 * 
	 * WebDriver driver = new ChromeDriver();
	 * 
	 * driver.get(URL);
	 * 
	 * driver.manage().window().maximize();
	 * 
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 * 
	 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);
	 * 
	 * driver.findElement(By.xpath("(//a[contains(.,'Organizations')])[1]")).click()
	 * ;
	 * driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 * 
	 * WebElement oname = driver.findElement(By.name("accountname"));
	 * 
	 * FileInputStream fi = new FileInputStream("./Data/orgnasation.xlsx");
	 * 
	 * Workbook wb = WorkbookFactory.create(fi);
	 * 
	 * Sheet sh = wb.getSheet("org");
	 * 
	 * Row row = sh.getRow(1);
	 * 
	 * Cell cel = row.getCell(2);
	 * 
	 * String data = cel.getStringCellValue();
	 * 
	 * System.out.println(cel);
	 * 
	 * wb.close();
	 * 
	 * Random ran = new Random();
	 * 
	 * int randomno = ran.nextInt(1000);
	 * 
	 * oname.sendKeys(data + randomno);
	 * 
	 * driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	 * 
	 * String requiredOrgName =
	 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	 * 
	 * Thread.sleep(4000);
	 * 
	 * driver.findElement(By.linkText("Contacts")).click();
	 * driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	 * WebElement lname = driver.findElement(By.name("lastname"));
	 * 
	 * 
	 * FileInputStream f = new FileInputStream("./Data/orgnasation.xlsx");
	 * 
	 * Workbook wb1 = WorkbookFactory.create(f);
	 * 
	 * Sheet sh1 = wb.getSheet("org");
	 * 
	 * Cell cel1 = sh.getRow(1).getCell(5);
	 * 
	 * String ln = cel.getStringCellValue();
	 * 
	 * Random ran1 = new Random();
	 * 
	 * int ranNo = ran.nextInt(1000);
	 * 
	 * lname.sendKeys(ln+ranNo);
	 * 
	 * driver.findElement(By.xpath("(//img[@style='cursor:hand;cursor:pointer'])[1]"
	 * )).click();
	 * 
	 * String parent = driver.getWindowHandle(); Set<String> tabs =
	 * driver.getWindowHandles(); for (String tab : tabs) {
	 * driver.switchTo().window(tab); }
	 * 
	 * List<WebElement> orgname = driver.findElements(By.xpath("//a"));
	 * 
	 * for (WebElement webElement : orgname) {
	 * if(webElement.getText().equals(requiredOrgName)) {webElement.click();
	 * 
	 * }
	 * 
	 * }
	 * 
	 * driver.switchTo().window(parent);
	 * 
	 * WebElement so = driver.findElement(By.
	 * xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
	 * 
	 * 
	 * Actions a = new Actions(driver);
	 * 
	 * a.moveToElement(so).perform();
	 * 
	 * Thread.sleep(2000);
	 * 
	 * driver.findElement(By.linkText("Sign Out")).click();
	 * 
	 * 
	 * 
	 * Thread.sleep(5000);
	 * 
	 * 
	 * ArrayList<String> lst = new ArrayList<String>(tabs);
	 * 
	 * for (int i = 0; i < lst.size(); i++) {
	 * 
	 * String win = lst.get(i); driver.switchTo().window(win);
	 * 
	 * driver.close();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * }
	 */

	@Test(groups = "smokesuite")
	public void createContactWithOrganisation() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.clikOnOrgnaisation();
		OrganisationPage op = new OrganisationPage(driver);
		op.clickCreateOrganisationLookup();
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		String onmae = elib.getDataFromExcelSheet("org", 1, 2) + jlib.getRandomNumber();
		cno.sendDataToOrgName(onmae);
		cno.clickSave();
		OrgnaisationInfo oi = new OrgnaisationInfo(driver);
		System.out.println(oi.storeCreatedOrg());

		hp.clikOnContact();
		ContactPage cp = new ContactPage(driver);
		cp.clickOncreateContactLoolUp();
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		String lname = elib.getDataFromExcelSheet("contact", 1, 2) + jlib.getRandomNumber();
		cnp.sendDataToLastName(lname);
		cnp.clickOnSave(driver, lname);

	}

}
