package com.github.VipulKumarSinghTech;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class DateUtils {

    private DateUtils() {
    }

    public static Date convertToDate(LocalDate localDate, ZoneId zoneId) {
        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    public static Date convertToDate(LocalDateTime localDateTime, ZoneId zoneId) {
        return Date.from(localDateTime.atZone(zoneId).toInstant());
    }

    public static Date convertToDate(LocalDate localDate, LocalTime localTime, ZoneId zoneId) {
        return Date.from(localTime.atDate(localDate).atZone(zoneId).toInstant());
    }

    public static Date convertToDate(LocalTime localTime, ZoneId zoneId) {
        return convertToDate(LocalDate.now(), localTime, zoneId);
    }

    public static Date convertToDate(LocalDate localDate) {
        return convertToDate(localDate, ZoneId.systemDefault());
    }

    public static Date convertToDate(LocalTime localTime) {
        return convertToDate(localTime, ZoneId.systemDefault());
    }

    public static Date convertToDate(LocalDateTime localDateTime) {
        return convertToDate(localDateTime, ZoneId.systemDefault());
    }

    public static Date convertToDate(LocalDate localDate, LocalTime localTime) {
        return convertToDate(localDate, localTime, ZoneId.systemDefault());
    }

    public static Date convertToDate(java.sql.Date sqlDate) {
        return new Date(sqlDate.getTime());
    }

    public static Date convertToDate(Time sqlTime) {
        return new Date(sqlTime.getTime());
    }

    public static Date convertToDate(Timestamp sqlTimeStamp) {
        return Date.from(sqlTimeStamp.toInstant());
    }

    public static Date convertToDate(String dateString, String dateFormat) throws ParseException {
        return new SimpleDateFormat(dateFormat).parse(dateString);
    }

    public static LocalDate convertToLocalDate(Date date, ZoneId zoneId) {
        return Instant.ofEpochMilli(date.getTime()).atZone(zoneId).toLocalDate();
    }

    public static LocalDate convertToLocalDate(Date date) {
        return convertToLocalDate(date, ZoneId.systemDefault());
    }

    public static LocalDate convertToLocalDate(LocalDateTime localDateTime) {
        return localDateTime.toLocalDate();
    }

    public static LocalDateTime convertToLocalDateTime(Date date, ZoneId zoneId) {
        return Instant.ofEpochMilli(date.getTime()).atZone(zoneId).toLocalDateTime();
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return convertToLocalDateTime(date, ZoneId.systemDefault());
    }

    public static LocalDateTime convertToLocalDateTime(LocalDate localDate) {
        return localDate.atStartOfDay();
    }

    public static LocalDateTime convertToLocalDateTime(LocalDate localDate, LocalTime localTime) {
        return localDate.atTime(localTime);
    }
}
