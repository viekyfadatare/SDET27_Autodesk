package com.crm.autodesk.genricutility;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * it Contains WebDriver Specific reusable action
 * 
 * @author admin
 *
 */

public class WebDriverUtility {
	/**
	 * wait for load before identyfying any synchoniaed epement in DOM
	 * 
	 * @param driver
	 */

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * wait for load before identyfying any synchoniaed element in DOM[Java Script
	 * ACtion] elemnt in DOM[html(document)]
	 * 
	 * @param driver
	 */
	public void waitForPageLoadForJsElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be clickable in GUI & check for specific element
	 * for every 500mili second
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBEClickable(WebDriver driver, WebElement element) {
		WebDriverWait ww = new WebDriverWait(driver, 20);
		ww.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * used to wait for element to be clikable GUI & Check specific elemnt for every
	 * 500mili second
	 * 
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws Throwable
	 */
	public void wiatForElemenwithCustomTimeout(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
/**
 * Wiat For Elemenet to visible And performing furthor activity 
 * @param driver
 * @param element
 */
	public void wiatForElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait ww = new WebDriverWait(driver, 20);
		ww.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * used to switch any window based on window title
	 * 
	 * @param driver
	 * @param PartailWindowTitle
	 */
	public void switchToWindow(WebDriver driver, String PartailWindowTitle) {

		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String win = it.next();
			driver.switchTo().window(win);
			String CurretnWindowTitle = driver.getTitle();
			if (CurretnWindowTitle.contains(PartailWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * Used swtich alert window Nad Click on Ok Button
	 * 
	 * @param driver
	 */
	public void switchAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Uswed to switch to alet window and click on cancle;
	 * 
	 * @param driver
	 */
	public void switchToAlertWindowAndCancle(WebDriver driver) {
		driver.switchTo().alert().dismiss();

	}

	/**
	 * it used to switch the frame based on index
	 * 
	 * @param driver
	 * @param index
	 */
	public void swtichToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * used to switch to frame window based on id or name attritbue
	 * 
	 * @param driver
	 * @param id_name_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * It is used to select the value from dropdown list on basis on index
	 * 
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * it used to select the value from dropdown list on basis on visibile text
	 * 
	 * @param element
	 * @param value
	 */
	public void select(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * is used to perform mouse over action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnWebElemnt(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * used to perform right click on element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebElemnt(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}

	/**
	 * it is used to perform scrollig opertaion
	 * 
	 * @param driver
	 * @param javaScript
	 */
	public void executJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript, null);

	}

	/**
	 * it is used to wait and click
	 * 
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebElement element) throws Throwable {
		int count = 0;
		while (count < 20) {
			try {
				element.click();
				break;
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;

			}
		}
	}

	/**
	 * it is used to get ScreenShote
	 * 
	 * @param driver
	 * @param screenshotname
	 * @throws Throwable
	 */
	public void takeScreenShote(WebDriver driver, String screenshotname) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File ss = ts.getScreenshotAs(OutputType.FILE);
		File ssave = new File("./Screenshot/" + screenshotname + ".PNG");
		Files.copy(ss, ssave);
	}

	/**
	 * used to pass enter key
	 * 
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

}