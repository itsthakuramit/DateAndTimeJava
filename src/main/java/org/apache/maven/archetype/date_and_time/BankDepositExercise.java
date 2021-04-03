package org.apache.maven.archetype.date_and_time;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class BankDepositExercise 
{
	
	public static String getMaturityDate(String investmentDate, Period duration){
		
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate parseDate=LocalDate.parse(investmentDate,dtf);
		LocalDate maturityDate=parseDate.plusYears(duration.getYears());
		String date= maturityDate.format(dtf);
		return date;
	}
	
	
	public static String getInvestmentPeriod(String investmentDate, String maturityDate) {
		
		DateTimeFormatter dtf1= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate parseDate1=LocalDate.parse(investmentDate,dtf1);
		DateTimeFormatter dtf2= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate parseDate2=LocalDate.parse(maturityDate,dtf2);
		Period between= Period.between(parseDate1, parseDate2);
		String date ="< "+between.getYears()+" Years, "+between.getMonths()+" Months, "+between.getDays()+" Days >";
		return date;
		
	}
	
	
public static void main(String[] args) {	
		
		String maturityDate=BankDepositExercise.getMaturityDate("10-12-2018", Period.ofYears(10));
		System.out.println("Maturity Date: "+maturityDate);
		
		
		String duration=BankDepositExercise.getInvestmentPeriod("26-03-2015","26/10/2018");
		System.out.println("\nInvestment Duration: "+duration);

	}
}
