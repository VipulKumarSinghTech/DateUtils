package com.github.VipulKumarSinghTech;

import java.time.DateTimeException;

public class CalendarTypeException extends DateTimeException {

    private static final String MESSAGE = "Unsupported Calendar Type: ";

    public CalendarTypeException(CalendarType calendarType) {
        super(MESSAGE + calendarType);
    }
}
