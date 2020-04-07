package ch12.ex7;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeInterval {
    private Duration length;
    private LocalDateTime startDateTime;
    private TimeIntervalEvent event;

    TimeInterval(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if ((startDateTime == null || endDateTime == null) || (endDateTime.isBefore(startDateTime))) {
            throw new ArithmeticException("Wrong data");
        } else {
            this.startDateTime = startDateTime;
            this.length = Duration.between(startDateTime, endDateTime);
        }
    }
    TimeInterval(LocalDateTime startDateTime, long minutes) {
        if (startDateTime == null || minutes <= 0) {
            throw new ArithmeticException("Wrong data");
        } else {
            this.startDateTime = startDateTime;
            this.length = Duration.ofMinutes(minutes);
        }
    }

    private TimeIntervalEvent getEvent() {
        return event;
    }

    void setEvent() {
        this.event = (new TimeIntervalEvent(startDateTime, length));
    }

    boolean isOverlapping(TimeInterval date2) {
        boolean endDate2BiggerThanStartDate1 = (date2.getEvent().endEvent).compareTo(this.event.startEvent) >= 0;
        boolean startDate2BiggerThanEndDate1 = (date2.getEvent().startEvent).compareTo(this.event.endEvent) >= 0;
        boolean endDate1BiggerThanStartDate2 = (this.event.endEvent).compareTo(date2.getEvent().startEvent) >= 0;
        boolean startDate1BiggerThanEndDate2 = (this.event.startEvent).compareTo(date2.getEvent().endEvent) >= 0;

        return !((endDate2BiggerThanStartDate1 && startDate2BiggerThanEndDate1) || (endDate1BiggerThanStartDate2 && startDate1BiggerThanEndDate2));
    }

    private static class TimeIntervalEvent {
        private LocalDateTime startEvent;
        private LocalDateTime endEvent;

        private TimeIntervalEvent(LocalDateTime startDateTime, Duration duration) {
            this.startEvent = startDateTime;
            this.endEvent = startEvent.plus(duration);
        }

    }
}
