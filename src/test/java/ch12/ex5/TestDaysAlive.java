package ch12.ex5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

class TestDaysAlive {

    static Stream<String[]> validData() {
        return Stream.of(
                new String[]{"1992-06-24", "2020-04-06", "10148"},
                new String[]{"2020-04-01", "2020-04-06", "5"},
                new String[]{"0001-01-01","2020-04-01","737515"}
        );
    }
    @ParameterizedTest
    @MethodSource("validData")
    public void should_Pass_Valid_Data(LocalDate birthday, LocalDate testDate, long num) {
        //given
        //when
        long expected = num;
        long actual = DaysAlive.daysAlive(birthday,testDate);
        //then
        Assertions.assertEquals(expected,actual);
    }

}