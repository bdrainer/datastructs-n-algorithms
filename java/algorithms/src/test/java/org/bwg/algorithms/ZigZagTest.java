package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * The exercise is asking to fix the errors in the code below.  The code should create a zigzag array which is
 * where the first half of the array increases in value and the last half of the array decreases in value.
 */
public class ZigZagTest {

    @Test
    void shouldCreateZigZagArray() {
        assertArrayEquals(new int[]{1, 2, 5, 4, 3}, doCreateZigZagArray(new int[]{2, 3, 5, 4, 1}));
        assertArrayEquals(new int[]{1, 2, 5, 4, 3}, doCreateZigZagArray(new int[]{2, 3, 5, 4, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 9, 8, 7, 6, 5}, doCreateZigZagArray(new int[]{2, 9, 5, 4, 8, 6, 7, 1, 3}));
    }

    /**
     * I have commented out the original code and put my changes below it.
     */
    private int[] doCreateZigZagArray(int[] a) {
        int n = a.length;

        Arrays.sort(a);

//        int mid = (n + 1)/2;
        int mid = n / 2;

        int temp = a[mid];

        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
//        int ed = n - 1;

        int ed = n - 2;

        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;

            ed = ed + 1;
//            ed = ed - 1;
        }
        return a;
    }
}
