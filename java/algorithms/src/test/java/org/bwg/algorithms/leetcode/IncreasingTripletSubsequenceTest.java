package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncreasingTripletSubsequenceTest {

    @Test
    void shouldWorkAsExpected() {
//        assertTrue(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
//        assertTrue(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
        assertTrue(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));

//        assertFalse(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) {
                small = num;
            } else if (num <= big) {
                big = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
