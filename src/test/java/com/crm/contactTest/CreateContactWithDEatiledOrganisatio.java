package com.crm.contactTest;

import java.io.FileInputStream; 

import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.Object.Repository.ContactInformation;
import com.crm.Object.Repository.ContactPage;
import com.crm.Object.Repository.CreateNewContactPage;
import com.crm.Object.Repository.CreatingNewOrganization;
import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.OrganisationPage;
import com.crm.Object.Repository.OrgnaisationInfo;
import com.crm.autodesk.genricutility.BaseClass;

public class CreateContactWithDEatiledOrganisatio extends BaseClass {

	/*public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream("./Data/commondata.properties");

		Properties pro = new Properties();

		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		String BROWSER = pro.getProperty("browser");

		ChromeDriver driver = new ChromeDriver();

		driver.get(URL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD, Keys.ENTER);
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[contains(.,'Organizations')]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		WebElement oname = driver.findElement(By.name("accountname"));

		FileInputStream f1 = new FileInputStream("./Data/orgnasation.xlsx");

		Workbook wb1 = WorkbookFactory.create(f1);
		Sheet sh1 = wb1.getSheet("org");

		Cell cel1 = sh1.getRow(1).getCell(2);

		String on = cel1.getStringCellValue();

		Random ran1 = new Random();
		int ranNo1 = ran1.nextInt(2000);

		String orgname = on + ranNo1;

		oname.sendKeys(orgname);

		// Now going to take indutrirs name and type
//
//		FileInputStream f2 = new FileInputStream("./Data/orgnasation.xlsx");
//
//		Workbook wb2 = WorkbookFactory.create(f2);

		Sheet sh2 = wb1.getSheet("contact");

		Cell cel2 = sh2.getRow(1).getCell(4);

		Cell cel3 = sh2.getRow(1).getCell(5);

		String Industry = cel2.getStringCellValue();
		String Type = cel3.getStringCellValue();

		WebElement ind = driver.findElement(By.name("industry"));

		Select s1 = new Select(ind);
		s1.selectByVisibleText(Industry);

		WebElement ty = driver.findElement(By.name("accounttype"));
		Select s2 = new Select(ty);
		s2.selectByVisibleText(Type);

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		WebDriverWait ww = new WebDriverWait(driver, 20);

		ww.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));

		String inde = driver.findElement(By.id("dtlview_Industry")).getText();
		String typ = driver.findElement(By.id("mouseArea_Type")).getText();

		if (Industry.equals(inde)) {
			System.out.println("You are select correct Industry");
		} else {
			System.out.println("You are  not select correct Industry");
		}

		if (Type.equals(typ)) {
			System.out.println("You are select correct Type");
		} else {
			System.out.println("You are  not select correct Type");
		}

		String requiredName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		System.out.println(requiredName);
		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement lname = driver.findElement(By.name("lastname"));

		Sheet sh3 = wb1.getSheet("org");

		Cell cel4 = sh3.getRow(1).getCell(2);

		String ln = cel4.getStringCellValue();

		Random ran2 = new Random();
		int ranNo2 = ran2.nextInt(2000);

		String lastName = ln + ranNo2;

		lname.sendKeys(lastName);

		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();

		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String currentID = it.next();
			driver.switchTo().window(currentID);

			String cPageTitle = driver.getTitle();
			if (cPageTitle.contains("Accounts")) {
				break;

			}

		}
		driver.findElement(By.name("search_text")).sendKeys(requiredName, Keys.ENTER);

		driver.findElement(By.xpath("//a[contains(.,'" + requiredName + "')]")).click();

		Set<String> set1 = driver.getWindowHandles();

		Iterator<String> it1 = set1.iterator();

		while (it1.hasNext()) {
			String currentId = it1.next();
			driver.switchTo().window(currentId);
			String cpageTitle = driver.getTitle();

			if (cpageTitle.contains("Contacts")) {
				break;
			}

		}
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		WebElement sout = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));

		Actions a = new Actions(driver);
		a.moveToElement(sout).perform();

		System.out.println(driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText());

		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(5000);

		driver.close();

	}*/
	
	@Test(groups = "reggressionsuite")
	public void creatContactWotOrgIndType() throws Throwable {
		HomePage hp = new HomePage(driver);

		hp.clikOnOrgnaisation();

		OrganisationPage op = new OrganisationPage(driver);
		op.clickCreateOrganisationLookup();

		CreatingNewOrganization cno = new CreatingNewOrganization(driver);

		String orgn = elib.getDataFromExcelSheet("org", 1, 2);
		String ind = elib.getDataFromExcelSheet("contact", 1, 4);
		String ty = elib.getDataFromExcelSheet("contact", 1, 5);
		int rn = jlib.getRandomNumber();

		cno.sendDataToOrgName(orgn + rn);
		cno.selectIndustry(ind);
		cno.selectType(ty);
		cno.clickSave();

		OrgnaisationInfo oi = new OrgnaisationInfo(driver);
		String orgname = oi.storeCreatedOrg();
		System.out.println(oi.storeCreatedOrg());

		if (oi.getVerifyOrgInfo().contains(orgn + rn)) {
			System.out.println("Organisations created succefully");
		} else {
			System.out.println("Organisations not created");
		}
	
		wlib.wiatForElementToBeVisible(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		
		hp.clikOnContact();

		ContactPage cp = new ContactPage(driver);
		cp.clickOncreateContactLoolUp();

		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.sendDataToLastName(elib.getDataFromExcelSheet("contact", 1, 1) + jlib.getRandomNumber());

		
		cnp.clickOneOrgNameLookUp();

		cnp.searchOrgName(driver, "Accounts", orgname);

		cnp.clickOnSave(driver, "Contacts");
		
		ContactInformation ci = new ContactInformation(driver);
	

		System.out.println(ci.getVerifycreatedContact());
	}

}
