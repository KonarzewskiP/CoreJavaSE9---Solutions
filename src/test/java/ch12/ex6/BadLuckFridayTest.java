package ch12.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BadLuckFridayTest {
    private BadLuckFriday badLuckFriday = new BadLuckFriday();
    private LocalDate startDate = LocalDate.of(1901, 1, 1);
    private LocalDate endDate = LocalDate.of(2000, 12, 31);

    static Stream<String> validFridays13th() {
        return Stream.of(
                "1962-07-13",
                "1902-06-13",
                "1938-05-13",
                "1945-07-13",
                "1998-02-13",
                "1998-03-13"
        );
    }

    @ParameterizedTest
    @MethodSource("validFridays13th")
    void should_Find_Given_Fridays13th(LocalDate date) {
        //given
        //when
        List<LocalDate> fridays13thList = badLuckFriday.getFridays13thIn20thCentury(startDate, endDate);
        //then
        Assertions.assertTrue(fridays13thList.contains(date));
    }

    @Test
    void should_Return_Correct_Length_Of_List() {
        //given
        LocalDate startDate = LocalDate.of(1998, 1, 1);
        LocalDate endDate = LocalDate.of(1998, 12, 31);
        int expectedLength = 3;
        //when
        List<LocalDate> fridays13thIn1998 = badLuckFriday.getFridays13thIn20thCentury(startDate, endDate);
        int actualLength = fridays13thIn1998.size();
        //then
        Assertions.assertEquals(expectedLength, actualLength);
    }
}