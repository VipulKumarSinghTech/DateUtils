package com.github.VipulKumarSinghTech;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
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
}
