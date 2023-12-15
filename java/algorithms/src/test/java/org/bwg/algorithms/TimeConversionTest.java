package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeConversionTest {

    @Test
    void shouldConvertDateTime() {
        assertEquals("00:00:00", convertDateTo24Hour("12:00:00AM"));
        assertEquals("23:59:59", convertDateTo24Hour("11:59:59PM"));
        assertEquals("07:05:45", convertDateTo24Hour("07:05:45AM"));
        assertEquals("19:05:45", convertDateTo24Hour("07:05:45PM"));
    }

    private String convertDateTo24Hour(String date) {
        LocalTime ldt = LocalTime.parse(date, DateTimeFormatter.ofPattern("hh:mm:ssa"));
        return ldt.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
