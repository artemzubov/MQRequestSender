package com.trgr.dockets.RequestSender.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeParser {

    public LocalDateTime parseDateTime(String serverDateTimeLinuxFormatted) {
        String[] s = serverDateTimeLinuxFormatted.split(" ");
        int day = Integer.parseInt(s[3]);
        int year = Integer.parseInt(s[6]);
        String date = day + "-" + s[1] + "-" + year;
        LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ofPattern("d-MMM-yyyy"));
        LocalTime lt = LocalTime.parse(s[4], DateTimeFormatter.ofPattern("HH:mm:ss"));
        return LocalDateTime.of(ld, lt);
    }
}
