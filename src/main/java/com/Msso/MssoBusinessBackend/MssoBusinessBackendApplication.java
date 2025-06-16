package com.Msso.MssoBusinessBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MssoBusinessBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(MssoBusinessBackendApplication.class, args);
		System.out.println("MSSO APPLICATION STARTED....");
		List<LocalDate> marchEndDates = getLastThreeMarchEndDates();
		marchEndDates.forEach(System.out::println);
		LocalDate quarterEnd = getCurrentQuarterEndDate();
		System.out.println("Current Quarter End Date: " + quarterEnd);

	}
	public static List<LocalDate> getLastThreeMarchEndDates() {
		int currentYear = LocalDate.now().getYear();
		List<LocalDate> marchEnds = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			LocalDate marchEnd = LocalDate.of(currentYear - i, Month.MARCH, 31);
			marchEnds.add(marchEnd);
		}

		return marchEnds;
	}
	public static LocalDate getCurrentQuarterEndDate() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int currentMonth = today.getMonthValue();

		int quarterEndMonth;

		if (currentMonth <= 3) {
			quarterEndMonth = 3;   // Q1 ends in March
		} else if (currentMonth <= 6) {
			quarterEndMonth = 6;   // Q2 ends in June
		} else if (currentMonth <= 9) {
			quarterEndMonth = 9;   // Q3 ends in September
		} else {
			quarterEndMonth = 12;  // Q4 ends in December
		}

		YearMonth ym = YearMonth.of(year, quarterEndMonth);
		return ym.atEndOfMonth();
	}
}
