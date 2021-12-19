package com.github.VipulKumarSinghTech;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateAddition {

    private DateAddition() {
    }

    public static Date add(Date date, CalendarType calendarType, Long n) {
        if (calendarType == CalendarType.MILLISECONDS)
            return new Date(date.getTime() + n);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarType.getValue(), n.intValue());
        return c.getTime();
    }

    public static LocalDate add(LocalDate localDate, CalendarType calendarType, Long n) {
        switch (calendarType) {
            case DAY:
                return localDate.plusDays(n);
            case WEEK:
                return localDate.plusWeeks(n);
            case MONTH:
                return localDate.plusMonths(n);
            case YEAR:
                return localDate.plusYears(n);
            default:
                Date date = DateUtils.convertToDate(localDate);
                Date newDate = add(date, calendarType, n);
                return DateUtils.convertToLocalDate(newDate);
        }
    }

    public static LocalTime add(LocalTime localTime, CalendarType calendarType, Long n) {
        if (calendarType.isDateType())
            throw new CalendarTypeException(calendarType);

        switch (calendarType) {
            case MILLISECONDS:
                return localTime.plus(n, ChronoUnit.MILLIS);
            case SECONDS:
                return localTime.plusSeconds(n);
            case MINUTE:
                return localTime.plusMinutes(n);
            case HOUR:
                return localTime.plusHours(n);
            default:
                return localTime;
        }
    }

    public static LocalDateTime add(LocalDateTime localDateTime, CalendarType calendarType, Long n) {
        switch (calendarType) {
            case MILLISECONDS:
                return localDateTime.plus(n, ChronoUnit.MILLIS);
            case SECONDS:
                return localDateTime.plusSeconds(n);
            case MINUTE:
                return localDateTime.plusMinutes(n);
            case HOUR:
                return localDateTime.plusHours(n);
            case DAY:
                return localDateTime.plusDays(n);
            case WEEK:
                return localDateTime.plusWeeks(n);
            case MONTH:
                return localDateTime.plusMonths(n);
            case YEAR:
                return localDateTime.plusYears(n);
        }
        return localDateTime;
    }

    public static java.sql.Date add(java.sql.Date sqlDate, CalendarType calendarType, Long n) {
        if (calendarType == CalendarType.MILLISECONDS)
            return new java.sql.Date(sqlDate.getTime() + n);

        Calendar c = Calendar.getInstance();
        c.setTime(sqlDate);
        c.add(calendarType.getValue(), n.intValue());
        return new java.sql.Date(c.getTimeInMillis());
    }

    public static Time add(Time time, CalendarType calendarType, Long n) {
        if (calendarType.isDateType())
            throw new CalendarTypeException(calendarType);

        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(calendarType.getValue(), n.intValue());
        return new Time(c.getTimeInMillis());
    }

    public static Timestamp add(Timestamp timestamp, CalendarType calendarType, Long n) {
        Calendar c = Calendar.getInstance();
        c.setTime(timestamp);
        c.add(calendarType.getValue(), n.intValue());
        return new Timestamp(c.getTimeInMillis());
    }

    public static String add(String dateString, String format,
                             CalendarType calendarType, Long n) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(dateString);
        date = add(date, calendarType, n);
        return sdf.format(date);
    }

}
