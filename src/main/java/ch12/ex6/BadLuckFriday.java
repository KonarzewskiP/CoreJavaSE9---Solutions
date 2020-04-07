package ch12.ex6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class BadLuckFriday {
    LocalDate startDate = LocalDate.of(1901, 1, 1);
    LocalDate endDate = LocalDate.of(2000, 12, 31);

    List<LocalDate> getFridays13thIn20thCentury(LocalDate startDate, LocalDate endDate) {
        return startDate.datesUntil(endDate)
                .filter(date -> date.getDayOfMonth() == 13)
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.toList());
    }
}
