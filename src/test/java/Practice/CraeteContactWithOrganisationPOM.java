package Practice;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.Object.Repository.ContactInformation;
import com.crm.Object.Repository.ContactPage;
import com.crm.Object.Repository.CreateNewContactPage;
import com.crm.Object.Repository.CreatingNewOrganization;
import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.Login;
import com.crm.Object.Repository.OrganisationPage;
import com.crm.Object.Repository.OrgnaisationInfo;
import com.crm.autodesk.genricutility.BaseClass;
import com.crm.autodesk.genricutility.ExcelUtility;
import com.crm.autodesk.genricutility.FileUtility;
import com.crm.autodesk.genricutility.JavaUtility;
import com.crm.autodesk.genricutility.WebDriverUtility;

public class CraeteContactWithOrganisationPOM extends BaseClass{
	
	@Test
public void createcontactWithOrgTestcase1() throws Throwable
{
	//public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
	/*	FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		ExcelUtility elib = new ExcelUtility();*/

		/*String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");*/

	/*	WebDriver driver = null;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser is not availabe");
		}*/
	
	    /*wLib.waitForPageToLoad(driver);
		driver.get(URL);
		driver.manage().window().maximize();

		Login lg = new Login(driver);

		lg.login(USERNAME, PASSWORD);*/
	

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
	
	@Test
	public void printMethod() {
		System.out.println("============This is Regional============= ");
	}

}
