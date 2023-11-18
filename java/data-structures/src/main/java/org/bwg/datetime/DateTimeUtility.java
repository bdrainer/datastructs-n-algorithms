package org.bwg.datetime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtility {

    /**
     * The timeString argument must be in the format "hh:mm:ssa", for example 07:05:45AM or 08:10:30PM.  The function
     * converts the AM/PM time to military format.  For example, 07:05:45AM is converted to 19:05:45.
     *
     * @param timeString The AM/PM time value in 'hh:mm:ssa' format.
     * @return The military time of the AM/PM value.
     */
    public static String convertToMilitaryTime(String timeString) {
        LocalTime timeValue = LocalTime.from(DateTimeFormatter.ofPattern("hh:mm:ssa").parse(timeString));
        return timeValue.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
