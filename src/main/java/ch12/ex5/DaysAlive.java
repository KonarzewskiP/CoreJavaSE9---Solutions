package ch12.ex5;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class DaysAlive {

    static long daysAlive(LocalDate birthday, LocalDate now) {
        return  ChronoUnit.DAYS.between(birthday, now);
    }
}
