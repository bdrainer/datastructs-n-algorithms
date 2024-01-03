package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxConsecutiveOnesTest {

    @Test
    void shouldWorkAsExpected() {
        assertEquals(6, longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        assertEquals(10, longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        assertEquals(4, longestOnes(new int[]{0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 2));
    }

    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int j = 0;

        while (i < nums.length) {
            if (nums[i] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[j] == 0) {
                    k++;
                }
                j++;
            }
            i++;
        }
        return i - j;
    }

}
