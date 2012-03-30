package com.opendroid.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.net.ParseException;

public class DateHelper {

	/* Method to calculate the difference between to dates.
	 * 
	 * date1 and date2 are the two dates in string type.
	 * dateFormat is the format using which two date objects will be created from 
	 * corresponding date strings.
	 * 
	 * return the difference in HH:MM format. 
	 * 
	 */

	public static String getDateTimeDifference(String date1, String date2,
			String dateFormat) {

		Date dateObj1;
		Date dateObj2;
		long diff;
		double diffInHours = 0;
		
		try {

			// String format = "dd-MMM-yyyy hh:mm";
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);

			dateObj1 = sdf.parse(date1);
			dateObj2 = sdf.parse(date2);

			System.out.println(dateObj1);
			System.out.println(dateObj2);

			diff = dateObj2.getTime() - dateObj1.getTime();
			diffInHours = diff / ((double) 1000 * 60 * 60);

			System.out.println(diffInHours);
			System.out.println("Hours " + (int) diffInHours);
			System.out.println("Minutes " + (diffInHours - (int) diffInHours)
					* 60);

		} catch (java.text.ParseException e) {			
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// returns in HH:MM format
		return (("" + (int) diffInHours) + ":" + (diffInHours - (int) diffInHours) * 60);

	}

}
