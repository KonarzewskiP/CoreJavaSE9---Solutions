package ch12.ex4;

import java.time.LocalDate;
import java.time.Year;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

public class CalendarEX4 {
    private LocalDate localDate;
    private int year;

    CalendarEX4(int year, int month) {
        localDate = LocalDate.of(year, month, 1);
        this.year = year;
    }


    public void printMonth() {
        int length = localDate.getMonth().length(Year.isLeap(year));
        int firstDayOfTheMonth = localDate.with(firstDayOfMonth()).getDayOfWeek().getValue();
        int i = 1;
        System.out.println(localDate.getMonth());
        for (int j = 1; j < 36; j++) {
            if (j == firstDayOfTheMonth && i <= length) {
                System.out.print("\t" + i++);
                firstDayOfTheMonth++;
            } else {
                System.out.print("\t-");
            }
            if (j % 7 == 0) {
                System.out.println();
            }
        }
    }

}
