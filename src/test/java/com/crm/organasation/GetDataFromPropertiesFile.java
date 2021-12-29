package com.crm.organasation;

import java.awt.Desktop.Action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.Object.Repository.CreatingNewOrganization;
import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.OrganisationPage;
import com.crm.autodesk.genricutility.BaseClass;

public class GetDataFromPropertiesFile extends BaseClass {

	/*public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("./Data/commondata.properties");

		Properties pro = new Properties();
		pro.load(fis);

		String URL = pro.getProperty("url");
		String PASSWORD = pro.getProperty("password");
		String USERNAME = pro.getProperty("username");
		String BROWSER = pro.getProperty("browser");

		WebDriver driver = new ChromeDriver();

		driver.get(URL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);

		driver.findElement(By.xpath("(//a[contains(.,'Organizations')])[1]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		WebElement oname = driver.findElement(By.name("accountname"));

		FileInputStream fi = new FileInputStream("./Data/orgnasation.xlsx");

		Workbook wb = WorkbookFactory.create(fi);

		Sheet sh = wb.getSheet("org");

		Row row = sh.getRow(1);

		Cell cel = row.getCell(2);

		String data = cel.getStringCellValue();

		System.out.println(cel);

		wb.close();

		Random ran = new Random();

		int randomno = ran.nextInt(1000);

		oname.sendKeys(data+randomno);

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		WebElement name = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));

		System.out.println(name.getText());
		
	WebElement so = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
	
	  
	Actions a = new Actions(driver);
	
	a.moveToElement(so).perform();
	
	Thread.sleep(2000);
	
	driver.findElement(By.linkText("Sign Out")).click();
	
	Thread.sleep(5000);
	
	driver.close();
	
	}*/
	
	@Test
	public void createOrg() throws Throwable {
		
		HomePage hp = new HomePage(driver);
		hp.clikOnOrgnaisation();
		OrganisationPage op = new OrganisationPage(driver);
		op.clickCreateOrganisationLookup();
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		String oname = elib.getDataFromExcelSheet("org", 1, 2) + jlib.getRandomNumber();
		cno.sendDataToOrgName(oname);
		String ind = elib.getDataFromExcelSheet("contact", 1, 4);
		String ty = elib.getDataFromExcelSheet("contact", 1, 5);
		cno.selectIndustry(ind);
		cno.selectType(ty);
		cno.clickSave();
		wlib.wiatForElementToBeVisible(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		
	}

}
