package org.apache.maven.archetype.date_and_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WorkingDaysExercise {
	
	
	public static List<String> getNextMonthsWorkingDays() throws ParseException{
		
		List<String> workingDaysList = new ArrayList<>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		LocalDate todayDate = LocalDate.now();
		LocalDate lastDate = todayDate.withDayOfMonth(todayDate.getMonth().length(todayDate.isLeapYear()));

		LocalDate date1 = lastDate.plusDays(1);
		LocalDate date2 = date1.withDayOfMonth(date1.getMonth().length(date1.isLeapYear()));

		String stringDate1 = date1.format(dtf);
		String stringDate2 = date2.format(dtf);

		Date startDate = sdf.parse(stringDate1);
		Date endDate = sdf.parse(stringDate2);

		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startDate);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(endDate);

		while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()) {
			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
				workingDaysList.add(sdf.format(startCal.getTime()));
			}
			startCal.add(Calendar.DAY_OF_MONTH, 1);
		}
		return workingDaysList;
	}
	
	

	public static void main(String[] args) throws ParseException {
		
		System.out.println("List of working days of next month :");
		List<String> list=WorkingDaysExercise.getNextMonthsWorkingDays();
		list.forEach(System.out::println);
		

	}

}
