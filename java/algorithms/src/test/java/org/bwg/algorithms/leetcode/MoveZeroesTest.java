package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTest {

    @Test
    void shouldWorkAsExpected() {
        assertMoveZeroes(new int[] {1,3,12,0,0}, new int[] {0,1,0,3,12});
    }

    void assertMoveZeroes(int[] expected, int[] nums) {
        moveZeroes(nums);
        assertArrayEquals(expected, nums);
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = i; j > 0; j--) {
                    if (nums[j-1] == 0) {
                        int temp = nums[j-1];
                        nums[j-1] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
    }
}
