package com.crm.autodesk.genricutility;

import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

public class DataBaseUtility {
	@BeforeSuite
	public void dbConnection() {
		System.out.println("==========Database Connected============");
	}

	@AfterSuite
	public void dbCloseConnection() {
		System.out.println("=========Database Closed========");

	}

}
