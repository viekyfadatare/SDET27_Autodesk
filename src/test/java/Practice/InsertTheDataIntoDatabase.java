package Practice;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDatabase {
	public static void main(String[] args) throws SQLException {
		Driver driver = new Driver();

		DriverManager.registerDriver(driver);

		// Established connection between database

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");

		// issue the statement

		Statement statement = connection.createStatement();

		// execute quriy

		int result = statement.executeUpdate("insert into studentinfo(id,fname,lname,adress) value(3,'modi','chacha','hindustna')");

		// vereification
		if (result ==1) {
			System.out.println("=== dta is added to database===");
		} else {
			System.out.println("=== dta is not added to database===");

		}
		// close the conncetion

		connection.close();
	}

}
