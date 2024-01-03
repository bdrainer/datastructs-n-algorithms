package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelfTest {

    @Test
    void shouldWordAsExpected() {
        assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{0, 0, 9, 0, 0}, productExceptSelf(new int[]{-1, 1, 0, -3, 3}));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int zeroIndex = -1;
        int zeroCount = 0;
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                zeroCount++;
                if (zeroCount > 1) {
                    break;
                }
            }
        }
        if (zeroCount == 1) {
            for (int i = 0; i < nums.length; i++) {
                if (i != zeroIndex) {
                    product = product * nums[i];
                } else {
                    result[i] = 0;
                }
            }
            result[zeroIndex] = product;
        } else if (zeroCount > 1) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = 0;
            }
        } else {
            for (int i = 1; i < nums.length; i++) {
                product = product * nums[i];
            }
            result[0] = product;
            for (int i = 1; i < nums.length; i++) {
                result[i] = result[i - 1] / nums[i] * nums[i - 1];
            }
        }
        return result;
    }
}
