package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindPivotIndexTest {

    @Test
    void shouldWorkAsExpected() {
//        assertEquals(3, pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
//        assertEquals(-1, pivotIndex(new int[]{1, 2, 3}));
//        assertEquals(0, pivotIndex(new int[]{2, 1, -1}));
        assertEquals(4, pivotIndex(new int[]{-1, -1, 1, 1, 0, 0}));
        assertEquals(0, pivotIndex(new int[]{0}));
    }

    public int pivotIndex(int[] nums) {
        int ri;
        int li = 0;
        int sum = 0;

        if (nums.length == 1) {
            return 0;
        }

        if (nums.length > 1) {
            for (int num : nums) {
                sum += num;
            }
            if (0 == sum - nums[0]) {
                return 0;
            }

            for (int i = 1; i < nums.length; i++) {
                ri = sum - nums[i] - nums[i - 1] - li;
                li = sum - ri - nums[i];
                if (li == ri) {
                    return i;
                }
            }
            if (0 == sum - nums[nums.length - 1]) {
                return nums.length - 1;
            }
        }

        return -1;
    }
}
