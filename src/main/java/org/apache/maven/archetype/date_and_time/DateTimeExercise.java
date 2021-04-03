package org.apache.maven.archetype.date_and_time;

import java.time.LocalDate;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DateTimeExercise {
	
	
	public static ArrayList<String> getExpiringTables(ArrayList<Tablet> tabletList, int months){
		
		ArrayList<String> list = new ArrayList<>();
		LocalDate todayDate= LocalDate.now();
		LocalDate nextDate=todayDate.plusMonths(months);
		System.out.println(nextDate);
		
		for(Tablet tab : tabletList){
			if(tab.getTabExpiryDate().isBefore(nextDate))
				list.add(tab.getTabName());
		}
		return list;		
	}
	
	public static ArrayList<Tablet> getExpiringTabletsSorted(ArrayList<Tablet> tabletList){
		
		Comparator<Tablet> comparator= new Comparator<Tablet>() {
			@Override
			public int compare(Tablet o1, Tablet o2) {
				LocalDate date1= o1.getTabExpiryDate();
				LocalDate date2=o2.getTabExpiryDate();
				return date1.compareTo(date2);
			}
		};
		
		Collections.sort(tabletList, comparator);
		return tabletList;
	}
	
	
	public static Map<String,String> getTabletExpiryPeriod(ArrayList<Tablet> tabletList){
		
		Map<String, String> tabletMap= new HashMap<>();
		
		for(Tablet tab : tabletList){
		String tabletName= tab.getTabName();
		Period between=Period.between(tab.getTabManufactureDate(), tab.getTabExpiryDate());
		String date ="< "+between.getYears()+" Year/s "+between.getMonths()+" Month/s "+between.getDays()+" Day/s >";
		tabletMap.put(tabletName, date);
		}
		
		return tabletMap;
	}
	
	
	public static Map<String,List<String>> getSameYearExpiry(ArrayList<Tablet> tabletList){
		
		Map<String,List<String>> mapTablet= new HashMap<>();
		
		Set<String> nameSet= new HashSet<>();
		LocalDate todayDate= LocalDate.now();
		int year=todayDate.getYear();
		
		for(Tablet tablet : tabletList){
			nameSet.add(tablet.getTabManufacture());
		}		
		for(String str :nameSet) {
			List<String> tabletName= new ArrayList<>();
			for(Tablet tablet: tabletList) {
				if(str.equals(tablet.getTabManufacture())) {					
					if(todayDate.isAfter(tablet.getTabExpiryDate())) {
						tabletName.add(tablet.getTabName());					
						}				
					}
				mapTablet.put(str, tabletName);
				}
		
			}
		return mapTablet;
	}
	
	
	public static void main(String [] args)
	{
		
	ArrayList<Tablet> tabletList= new ArrayList<Tablet>();

	Tablet tablet1= new Tablet("Crocin", "GlaxoSmithKline", LocalDate.of(2020, 12, 26), LocalDate.of(2020, 10, 03));
	Tablet tablet2= new Tablet("Combiflam", "Sanofi India", LocalDate.of(2018, 10, 1), LocalDate.of(2020,10, 10));
	Tablet tablet3= new Tablet("Paracetamol", "GlaxoSmithKline", LocalDate.of(2020, 1, 5), LocalDate.of(2020,9, 1));
	Tablet tablet4= new Tablet("Disprin", "Banckiser", LocalDate.of(2020, 2, 8), LocalDate.of(2021 ,9, 8));
	Tablet tablet5= new Tablet("D-Cold", "Reckitt Benckiser Healthcare", LocalDate.of(2019,9, 9), LocalDate.of(2020,10, 19));
	
	tabletList.add(tablet1);
	tabletList.add(tablet2);
	tabletList.add(tablet3);
	tabletList.add(tablet4);
	tabletList.add(tablet5);
	
	
	List<String> tabNameList=DateTimeExercise.getExpiringTables(tabletList,6);
	System.out.println("\n--Expired Tablets--\n");
	tabNameList.forEach(System.out::println);
	
	List<Tablet> list= DateTimeExercise.getExpiringTabletsSorted(tabletList);
	System.out.println("\n--Sorted List of Tablets--\n");
	list.forEach(System.out::println);
	
	Map<String, String> tabletMap=DateTimeExercise.getTabletExpiryPeriod(tabletList);
	System.out.println("\n--Map of Tablets with duration of expiry--\n");
	tabletMap.forEach((k,v) -> System.out.println(k +" -> "+v));
	
	Map<String,List<String>> tabletManufactureMap=DateTimeExercise.getSameYearExpiry(tabletList);
	System.out.println("\n--List of tablet names which are already expired--\n");
	tabletManufactureMap.forEach((k,v) -> System.out.println(k +" -> "+v));
	}
}
