package ch12;

import java.time.DayOfWeek;
import java.time.temporal.*;

public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek
                = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));

        int daysToAdd;
        if (dayOfWeek == DayOfWeek.FRIDAY)
            daysToAdd = 3;
        else if (dayOfWeek == DayOfWeek.SATURDAY)
            daysToAdd = 2;
        else
            daysToAdd = 1;
        return temporal.plus(daysToAdd, ChronoUnit.DAYS);
    }
}
//    TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(
//            day -> {
//                DayOfWeek dow =
//                        DayOfWeek.of(day.get(ChronoField.DAY_OF_WEEK));
//                int dayToAdd = 1;
//                if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
//                else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
//                return day.plus(dayToAdd, ChronoUnit.DAYS);
//            });