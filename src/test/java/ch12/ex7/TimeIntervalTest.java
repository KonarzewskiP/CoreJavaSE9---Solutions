package ch12.ex7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

class TimeIntervalTest {

    static Stream<String[]> overlappingDates() {
        return Stream.of(
                new String[]{"2020-08-13T12:30:00", "2020-08-13T12:00:00", "60"},
                new String[]{"2020-08-13T11:00:00", "2020-08-13T11:45:00", "60"},
                new String[]{"1956-02-15T16:27:00", "1956-02-15T18:45:00", "240"},
                new String[]{"1999-09-09T22:30:00", "1999-09-10T00:15:00", "150"}
        );
    }

    @ParameterizedTest
    @MethodSource("overlappingDates")
    void should_Overlap(LocalDateTime date1, LocalDateTime date2, long length) {
        //given
        TimeInterval temp1 = new TimeInterval(date1, length);
        TimeInterval temp2 = new TimeInterval(date2, length);
        temp1.setEvent();
        temp2.setEvent();
        //when
        boolean actual = temp2.isOverlapping(temp1);
        //then
        Assertions.assertTrue(actual);
    }

    static Stream<String[]> notOverlappingDates() {
        return Stream.of(
                new String[]{"2020-08-13T12:30:00", "2020-08-13T11:29:00", "60"},
                new String[]{"2020-08-13T12:46:00", "2020-08-13T11:45:00", "60"},
                new String[]{"1956-02-12T16:27:00", "1956-02-15T18:45:00", "240"},
                new String[]{"1999-09-09T22:30:00", "1999-09-07T00:15:00", "150"}
        );
    }

    @ParameterizedTest
    @MethodSource("notOverlappingDates")
    void should_Not_Overlap(LocalDateTime date1, LocalDateTime date2, long length) {
        //given
        TimeInterval temp1 = new TimeInterval(date1, length);
        TimeInterval temp2 = new TimeInterval(date2, length);
        temp1.setEvent();
        temp2.setEvent();
        //when
        boolean actual = temp2.isOverlapping(temp1);
        //then
        Assertions.assertFalse(actual);
    }
}