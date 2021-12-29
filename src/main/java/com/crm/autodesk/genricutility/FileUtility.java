package com.crm.autodesk.genricutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	public String getPropertyKeyValue(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./Data/commondata.properties");
		
		Properties pro = new Properties();
		
		pro.load(fis);
		
		String data = pro.getProperty(key);
		
		return data;
		
	}

}
