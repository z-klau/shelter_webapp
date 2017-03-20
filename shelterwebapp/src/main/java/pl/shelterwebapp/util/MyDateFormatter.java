package pl.shelterwebapp.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateFormatter {
	
	public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	public static Date parseToDate(String date) {
		try {
			return DATE_FORMATTER.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String formatToString(Date date) {
		return DATE_FORMATTER.format(date);
	}
	

}
