package rmgyantaTestScript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertProjectData {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		
		Statement statement = connection.createStatement();
		
		int result = statement.executeUpdate("insert into project(project_id,created_by,created_on,project_name,status,team_size) value(7,'prakash','16/12/2021','timepass','completed','2')");
	
		if(result==1) {
			System.out.println("===data Is Succefully added==");
		}else {
			System.out.println("===data is not added==");
			
			
		}
		
		String exepectedName = "prakash";
		
		ResultSet res = statement.executeQuery("select* from project");
		
		while(res.next()) {
			
			if (res.getString(1).equals(exepectedName)) {
				System.out.println("Value is presenet in the database");
			}
		}
		
		
		
		
		connection.close();
	
	}

}
