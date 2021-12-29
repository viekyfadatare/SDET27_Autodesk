package com.crm.autodesk.genricutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author admin
 *
 */
public class JavaUtility {

	/**
	 * it is used to get Random Number
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int ranNO = ran.nextInt(2000);

		return ranNO;

	}

	/**
	 * It is used to get sysetem date and time in IST formate
	 * 
	 * @return
	 */
	public String getSystemDatenadTime() {
		Date date = new Date();
		return date.toString();
	}
	/**
	 * To get Date In YYYY-MM-DD
	 * @return
	 */

	public String getSystemDateWithFormate() {
		 Date date = new Date();
		 String dateANDtime = date.toString();
		 
		 String YYYY = dateANDtime.split(" ")[5];
		 String DD = dateANDtime.split(" ")[2];
		int MM=date.getMonth()+1;
		String finalFormate=YYYY+"-"+MM+"-"+DD; 
		return finalFormate;
		 
	 }

}
