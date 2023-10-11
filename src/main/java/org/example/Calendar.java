package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Calendar {

    private final int YEAR_TO_SUBSTRACT = 1900;
    private final int MONTH_INDEX_TO_SUBSTRACT = 1;
    private final int MIN_DAY_OF_MONTH = 1;
    private final int MAX_DAY_OF_MONTH = 31;

    public Calendar() {
    }

    public List<CalendarEntity> getMonthCalendar(String month, String year) {
        return this.iterateMonth(this.getDate(month, year));
    }

    public List<CalendarEntity> generateEventMonthCalendar(Date date, String event) {
        List<CalendarEntity> calendarEntities = new ArrayList<>();
        List<CalendarEntity> monthCalendar = this.iterateMonth(date);
        for (int i = 0; i < monthCalendar.size(); i++) {
            CalendarEntity calendarEntity = new CalendarEntity();
            calendarEntity.setCalendarDate(monthCalendar.get(i).getCalendarDate());
            if (monthCalendar.get(i).getCalendarDate().getDate() == date.getDate()) {
                calendarEntity.setEvent(event);
            }
            calendarEntities.add(calendarEntity);
        }
        return calendarEntities;
    }

    private Date getDate(String month, String year) {
        int monthIndex = Integer.parseInt(month) - this.MONTH_INDEX_TO_SUBSTRACT;
        int yearInt = Integer.parseInt(year) - this.YEAR_TO_SUBSTRACT;
        Date date = new Date(yearInt, monthIndex, this.MIN_DAY_OF_MONTH);
        return date;
    }

    private List<CalendarEntity> iterateMonth(Date date) {
        List<CalendarEntity> monthCalendar = new ArrayList<>();
        for (int i = 0; i <= this.MAX_DAY_OF_MONTH; i++) {
            Date newDate = new Date(date.getYear(), date.getMonth(), i);
            if (newDate.getMonth() == date.getMonth()) {
                CalendarEntity calendarEntity = new CalendarEntity();
                calendarEntity.setCalendarDate(newDate);
                monthCalendar.add(calendarEntity);
            }
        }
        return monthCalendar;
    }
}
