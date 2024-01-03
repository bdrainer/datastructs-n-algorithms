package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CanPlaceFlowersTest {

    @Test
    void shouldFindAnswers() {
        assertTrue(canPlaceFlowers(new int[]{0}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
        assertTrue(canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 1, 0, 0}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 1, 0, 0, 0}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 1, 0, 0, 0, 0}, 2));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
//
        assertFalse(canPlaceFlowers(new int[]{0, 1, 0}, 1));
        assertFalse(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return false;
        }
        if (flowerbed.length == 1) {
            return n == 1 && flowerbed[0] == 0;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            // starts with empty plot
            if (i == 0) {
                if (flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                    --n;
                    flowerbed[i] = 1;
                }
            }
            // ends with empty plot
            else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                --n;
                flowerbed[i] = 1;
            }
            // everything between start and end of array
            else if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                --n;
                flowerbed[i] = 1;
            }
            if (n == 0) {
                return true;
            }
        }
        return n == 0;
    }
}
