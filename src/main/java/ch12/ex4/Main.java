package ch12.ex4;

import java.time.LocalDate;
import java.time.Month;

import static java.time.temporal.TemporalAdjusters.*;

public class Main {
    public static void main(String[] args) {
        CalendarEX4 test = new CalendarEX4(2013,12);

        test.printMonth();
        }
    }

