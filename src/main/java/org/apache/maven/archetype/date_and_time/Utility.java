package org.apache.maven.archetype.date_and_time;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Utility {
	
	public static List<String> getBusSchedule(String start, Duration frequency) throws ParseException{

		List<String> timingList= new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime startTime = LocalDateTime.parse(start, formatter);
		LocalDateTime endTime=startTime.withHour(23).withMinute(59).withSecond(59);
		
		while(startTime.isBefore(endTime)) {
			timingList.add(startTime.toLocalTime().toString());
			startTime=startTime.plus(frequency);
		}
		return timingList;		
	}

	public static void main(String[] args) throws ParseException {
		System.out.println("List of the bus timings for a day :");
		List<String> timingList=Utility.getBusSchedule("2016-03-04 08:09:59", Duration.ofHours(3));
		timingList.forEach(System.out::println);

	}

}
