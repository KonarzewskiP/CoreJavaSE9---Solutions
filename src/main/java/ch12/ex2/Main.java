package ch12.ex2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2000,2,29);
        LocalDate date2 = date.plusYears(4);
        System.out.println(date2);

    }
}
