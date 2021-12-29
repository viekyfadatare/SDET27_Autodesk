package com.crm.autodesk.genricutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.Login;

public class BaseClass {

	public DataBaseUtility dlib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite(groups= {"smokesuite","reggressionsuite"})
	public void dbConnection() {
		dlib.dbConnection();
		System.out.println("=======DataBase Connected Succefully======");
	}

	@Parameters("browser")
	@BeforeClass(groups= {"smokesuite","reggressionsuite"})
	
	public void launchBrowser() throws Throwable {
		// read the data
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		sdriver = driver;
		
		driver.get(URL);
		driver.manage().window().maximize();
		wlib.waitForPageToLoad(driver);
	}

	@BeforeMethod(groups= {"smokesuite","reggressionsuite"})
	public void loginToApp() throws Throwable {
		// raed the data

		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");

		Login l = new Login(driver);
		l.login(USERNAME, PASSWORD);
		System.out.println("==========Login  to application succesufully========");
	}

	@AfterMethod(groups= {"smokesuite","reggressionsuite"})
	public void logOut() {

		HomePage hp = new HomePage(driver);
		hp.LogOut(driver);
		System.out.println("==========LogOut Succefully=============");

	}

	@AfterClass(groups= {"smokesuite","reggressionsuite"})
	public void closeBrowser() {
		driver.quit();

	}

	@AfterSuite(groups= {"smokesuite","reggressionsuite"})
	public void dbCloseConnection() {
		dlib.dbCloseConnection();
		System.out.println("========DatBase Connection Close Succefully====");

	}

}
