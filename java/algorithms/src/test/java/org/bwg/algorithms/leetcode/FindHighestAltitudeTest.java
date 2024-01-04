package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindHighestAltitudeTest {

    @Test
    void shouldWorkAsExpected() {
        assertEquals(1, largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        assertEquals(0, largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int altitude = 0;
        for (int g : gain) {
            altitude = altitude + g;
            if (max < altitude) {
                max = altitude;
            }
        }
        return max;
    }
}
