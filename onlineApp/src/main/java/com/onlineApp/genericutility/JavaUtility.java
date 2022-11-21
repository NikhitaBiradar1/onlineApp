


package com.onlineApp.genericutility;

import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Praveen
 * @since 1998
 *
 */
public class JavaUtility {

	
	public String generateRandomNumber(int range){

		Random ran=new Random();
		int num = ran.nextInt(range);
		String number = Integer.toString(num);
		return number;

	}
	public String  getSystemDateTime() {
		Date date = new Date();
		String currentDate = date.toString();
		//System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
		String time = arr[3].replace(":", "");
			String formate = dd+mm+yyyy+time;
			return formate;
	}
	public String  getSystemDate(String format) {
		String Date="";

		if(format.equalsIgnoreCase("YYYYMMDD")) {
			Date date = new Date();
			String currentDate = date.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");

			String yyyy = arr[5];
			String dd = arr[2];
			int mm = date.getMonth()+1;

			Date = yyyy+"-"+mm+"-"+dd;
			
		}
		/**
		 *  its used to get the current system date based on DD-MM-YYYY format 
		 * @return
		 */
		if(format.equalsIgnoreCase("DDMMYYYY")) {
			Date date = new Date();
			String currentDate = date.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");

			String yyyy = arr[5];
			String dd = arr[2];
			int mm = date.getMonth()+1;

			Date = dd+"-"+mm+"-"+yyyy;
		
		}
		/**
		 *  its used to get the current system date based on MM-DD-YYYY formate
		 * @return
		 */
		if(format.equalsIgnoreCase("MMDDYYYY")) {
			Date date = new Date(0);
			String currentDate = date.toString();
			System.out.println(currentDate);
			String[] arr = currentDate.split(" ");

			String yyyy = arr[5];
			String dd = arr[2];
			int mm = date.getMonth()+1;

			Date = mm+"-"+dd+"-"+yyyy;
			
		}
		return Date;

	}
}
