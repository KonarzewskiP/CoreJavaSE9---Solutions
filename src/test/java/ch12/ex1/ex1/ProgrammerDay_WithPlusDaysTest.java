package ch12.ex1.ex1;

import ch12.ex1.ProgrammerDay;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

class ProgrammerDay_WithPlusDaysTest {
    ProgrammerDay theDay = new ProgrammerDay();

    public static Stream<Integer> leapYears(){
        return Stream.of(1600,2020,2000,1588,4,3960,3544);
    }
    @ParameterizedTest
    @MethodSource("leapYears")
    public void should_Return_12_September(int year) {
        //given
        LocalDate expected = LocalDate.of(year,9,12);
        //when
        LocalDate actual = theDay.withPlusDays(year);
        //then
        Assertions.assertEquals(expected,actual);
    }

    public static Stream<Integer> normalYears(){
        return Stream.of(1700,2021,7842,1345,1,7843,7841);
    }
    @ParameterizedTest
    @MethodSource("normalYears")
    public void should_Return_13_September(int year) {
        //given
        LocalDate expected = LocalDate.of(year,9,13);
        //when
        LocalDate actual = theDay.withPlusDays(year);
        //then
        Assertions.assertEquals(expected,actual);
    }
}