package org.example;

import java.util.Date;

public class CalendarEntity {
    Date calendarDate;
    String event;

    public CalendarEntity() {
    }

    public Date getCalendarDate() {
        return calendarDate;
    }

    public String getEvent() {
        return event;
    }

    public void setCalendarDate(Date calendarDate) {
        this.calendarDate = calendarDate;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
