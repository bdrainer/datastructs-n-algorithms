package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxAverageSubarrayTest {

    @Test
    void shouldWorkAsExpected() {
//        assertEquals(Double.parseDouble("12.75"), findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
//        assertEquals(Double.parseDouble("5.0"), findMaxAverage(new int[] {5}, 1));
//        assertEquals(Double.parseDouble("2.0"), findMaxAverage(new int[]{0, 1, 1, 3, 3}, 4));
        assertEquals(Double.parseDouble("3.33"), findMaxAverage(new int[]{3, 3, 4, 3, 0}, 3), 0.01);
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return (double)(max) / k;
    }
}
