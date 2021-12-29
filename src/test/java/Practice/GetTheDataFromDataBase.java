package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetTheDataFromDataBase {

	public static void main(String[] args) throws Throwable {

		// register the database
		Driver driver = new Driver();

		DriverManager.registerDriver(driver);

		// Established connection between database

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

		// issue the statement

		Statement statement = connection.createStatement();

		// execute quriy

		ResultSet result = statement.executeQuery("select* from studentinfo");

		while (result.next()) {

			System.out.println(result.getObject(1) + "  " + result.getString(2));
		}

		// close the connection

		connection.close();

	}

}
