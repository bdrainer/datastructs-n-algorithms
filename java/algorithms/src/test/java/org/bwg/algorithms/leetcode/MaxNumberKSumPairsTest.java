package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxNumberKSumPairsTest {

    @Test
    void shouldWorkAsExpected() {
        assertEquals(2, maxOperations(new int[] {1,2,3,4}, 5));
        assertEquals(1, maxOperations(new int[] {3,1,3,4,3}, 6));
    }

    public int maxOperations(int[] nums, int k) {
        int count = 0;

        int i = 0;
        int j = nums.length - 1;

        Arrays.sort(nums);

        while (i < j) {
            if (nums[i] + nums[j] == k) {
                i++;
                j--;
                count++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                i++;
            }
        }

        return count;
    }
}
