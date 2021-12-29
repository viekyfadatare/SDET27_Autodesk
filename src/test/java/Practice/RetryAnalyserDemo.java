package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserDemo {
	
	@Test(retryAnalyzer = com.crm.autodesk.genricutility.RetryAnalyserImplementation.class)
	public void printStatement() {
		
		System.out.println("=======Retry_Anlyser==========");
		Assert.fail();
		
	}

}
