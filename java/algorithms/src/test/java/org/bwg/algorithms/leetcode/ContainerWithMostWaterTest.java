package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerWithMostWaterTest {

    @Test
    void shouldWorkAsExpected() {
        assertEquals(49, maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
        assertEquals(1, maxArea(new int[] {1,1}));
    }

    public int maxArea(int[] height) {
        int res;
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            if (height[i] <= height[j]) {
                res = height[i] * (j - i);
                i++;
            } else {
                res = height[j] * (j - i);
                j--;
            }
            ans = Math.max(res, ans);
        }
        return ans;
    }

    public int maxArea2(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int l = j - i;
                int h = Math.min(height[j], height[i]);
                int area = h * l;
                if (area > result) {
                    result = area;
                }
            }
        }
        return result;
    }
}
