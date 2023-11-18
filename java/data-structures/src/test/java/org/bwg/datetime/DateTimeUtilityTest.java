package org.bwg.datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeUtilityTest {

    @Test
    void testConvertToMilitaryTime() {
        assertEquals("07:05:45", DateTimeUtility.convertToMilitaryTime("07:05:45AM"));
        assertEquals("19:05:45", DateTimeUtility.convertToMilitaryTime("07:05:45PM"));
    }
}
