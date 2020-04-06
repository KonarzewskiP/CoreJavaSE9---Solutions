package ch12.ex1;

import java.time.LocalDate;
import java.time.Year;

public class ProgrammerDay {

    public LocalDate withPlusDays(int year) {
        return LocalDate.of(year, 1, 1).plusDays(255);
    }

    public LocalDate withOfYearDay(int year) {
        return LocalDate.ofYearDay(year, 256);
    }

    public LocalDate withDayOfTheYear(int year) {
        return LocalDate.of(year, 1, 1).withDayOfYear(256);
    }

    public LocalDate withDayOfTheMonth(int year) {
        return LocalDate.of(year, 9, (Year.isLeap(year) ? 12 : 13));
    }
}
