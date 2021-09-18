package com.github.VipulKumarSinghTech;

import java.util.Arrays;
import java.util.List;

public enum CalendarType {

    MILLISECONDS(14),
    SECONDS(13),
    MINUTE(12),
    HOUR(10),
    DAY(5),
    WEEK(4),
    MONTH(2),
    YEAR(1);

    private final int value;
    private static final List<CalendarType> timeTypeList =
            Arrays.asList(MILLISECONDS, SECONDS, MINUTE, HOUR);
    private static final List<CalendarType> dateTypeList =
            Arrays.asList(DAY, WEEK, MONTH, YEAR);

    CalendarType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isDateType() {
        return dateTypeList.contains(this);
    }

    public boolean isTimeType() {
        return timeTypeList.contains(this);
    }
}
