package rmgyantaTestScript;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class AddProject {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		String ExcepteProjectName = "autoit";
		WebDriver driver = new ChromeDriver();

		try {

			driver.get("http://localhost:8084/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");

			driver.findElement(By.name("password")).sendKeys("rmgy@9999");

			driver.findElement(By.xpath("//button[@type='submit']")).click();

			driver.findElement(By.xpath("//a[contains( .,'Projects')]")).click();
			driver.findElement(By.xpath("//span[contains( .,'Create Project')]")).click();
			driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("taktak");
			driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("mahesh");

			WebElement status = driver.findElement(By.xpath("(//select[@name='status'])[2]"));

			Select s1 = new Select(status);

			s1.selectByIndex(1);

			driver.findElement(By.xpath("//input[@value='Add Project']")).click();

			Thread.sleep(2000);
			
		} 
		
		finally {
			driver.close();
		}

		Driver driv = new Driver();

		DriverManager.registerDriver(driv);
		Connection connecton = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");

		Statement statement = connecton.createStatement();

		ResultSet result = statement.executeQuery("select* from project");

		while (result.next()) {
			System.out.println(result.getString(1) + "  " + result.getString(2) + "  " + result.getString(3) + "  "
					+ result.getString(3) + "  " + result.getString(4) + "  " + result.getString(5) + "  "
					+ result.getString(6));

		}

		System.out.println();
		System.out.println();
		while (result.next()) {
			if (result.getString(4).equals(ExcepteProjectName)) {

				System.out.println("Passed");
			}

		}

		connecton.close();

	}

}
