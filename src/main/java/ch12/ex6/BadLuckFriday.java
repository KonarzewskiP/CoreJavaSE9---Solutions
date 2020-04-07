package ch12.ex6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BadLuckFriday {
    LocalDate startDate = LocalDate.of(1900, 1, 1);
    LocalDate endDate = LocalDate.of(1999, 12, 31);

    public static List<LocalDate> getDateRangeJava9(LocalDate startDate, LocalDate endDate) {
        return startDate.datesUntil(endDate)
                .filter(date -> date.getDayOfMonth() == 13)
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.toList());
    }
}
