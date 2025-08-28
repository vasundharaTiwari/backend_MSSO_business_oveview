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
		LocalDate marchEndDates = getFinancialYearEndDate(LocalDate.parse("2024-08-25"));
		//System.out.println(marchEndDates);
		LocalDate quarterEnd = getCurrentQuarterEndDate();
	//	System.out.println("Current Quarter End Date: " + quarterEnd);
		int currentYear = LocalDate.now().getYear();

		LocalDate marchEndLatest = LocalDate.of(currentYear - 0, Month.MARCH, 31);
		//System.out.println("last march date :-"+marchEndLatest);
	}
	public static LocalDate getFinancialYearEndDate(LocalDate visit_Date) {
		LocalDate today = visit_Date;
		int year = today.getYear();

		if (today.isBefore(LocalDate.of(year, Month.APRIL, 1))) {
			// Jan 1 - Mar 31 : financial year ends this year on Mar 31
			return LocalDate.of(year, Month.MARCH, 31);
		} else {
			// Apr 1 - Dec 31 : financial year ends next year on Mar 31
			return LocalDate.of(year + 1, Month.MARCH, 31);
		}

	}
	public static LocalDate getCurrentQuarterEndDate() {
		LocalDate today = LocalDate.parse("2025-03-01");
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
