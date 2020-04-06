package ch12.ex5;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        System.out.println(DaysAlive.daysAlive(LocalDate.of(1, 1, 1), LocalDate.now()));
    }
}
