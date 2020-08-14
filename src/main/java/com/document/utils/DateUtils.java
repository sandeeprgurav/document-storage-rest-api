package com.document.utils;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;

public class DateUtils {
  
	public static LocalDate getStringToDate(String date) throws Exception {				
	    return LocalDate.parse(date);
	}
	
	public static YearMonth getStringToYearMonth(String date) throws Exception {				
	    return YearMonth.parse(date);
	}
	
	public static Year getStringToYear(String date) throws Exception {				
	    return Year.parse(date);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getStringToDate("2020-07-22"));	
		System.out.println(getStringToYearMonth("2020-07"));
		System.out.println(getStringToYear("2020"));
	}
}
