package ru.rsreu.exchangethings.model.datalayer;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateFormatter {
    private static final String DATE_FORMAT = "yyyy-MM-dd";

    private DateFormatter() {
    }

    public static Date getSimpleDateFormatTime(String date) throws ParseException {
        return new Date(new SimpleDateFormat(DATE_FORMAT).parse(date).getTime());
    }


}
