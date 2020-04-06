package ch12.ex3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        LocalDate today2 = today.with(Objects.requireNonNull(nextDay(w ->
                today.getDayOfWeek().getValue() < 6
        )));

    }

    //            today.with(nextDay(w -> getDayOfWeek().getValue<6));
    public static LocalDate nextDay(Predicate<LocalDate> w) {
        return null;
    }

    //ZADANIE
//        Zaimplementuj metodę  następny , która pobiera  Predicate<LocalDate> i zwraca
//        modyfikator, zwracający kolejną datę spełniającą predykat. Na przykład

//        dziś.with(następny(w -> getDayOfWeek().getValue() < 6))

//        oblicza kolejny dzień roboczy.
}

