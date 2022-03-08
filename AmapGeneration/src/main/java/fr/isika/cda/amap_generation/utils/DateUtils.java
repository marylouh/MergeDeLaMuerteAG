package fr.isika.cda.amap_generation.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

	public static Date formDate(int year, int month, int day) {
		LocalDate dateSaisie = LocalDate.of(year, month, day);
		return Date.from(dateSaisie.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date getTodaysDate() {
		return Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static String formDate(LocalDate currentDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    String date = currentDate.format(formatter);
		return date;
	}

}
