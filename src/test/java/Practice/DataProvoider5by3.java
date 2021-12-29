package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvoider5by3 {
	
	@Test(dataProvider = "getData")
	public void readDataFromDataProviderTest(String name , int qty, String city) {
		
		System.out.println("Mobile  =>"+name+"  Mob Quatity   =>"+qty + "   City   =>"+city);
	}
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] objArr = new Object[5][3];
		
		objArr[0][0] = "Iphone";
		objArr[0][1] = 10;
		objArr[0][2] = "Pune";

		
		objArr[1][0] = "Samsumg";
		objArr[1][1] = 20;
		objArr[1][2] = "Bangalore";

		
		
		objArr[2][0] = "Vivo";
		objArr[2][1] =  30;
		objArr[2][2] = "Mumbai";

		
		
		objArr[3][0] = "Nokia";
		objArr[3][1] = 40;
		objArr[3][2] = "Delhi";

		
		
		objArr[4][0] = "Micromax";
		objArr[4][1] =  50;
		objArr[4][2] = "Lakhanua";

		

		
		return objArr;
		
		
				
	}
	

}
