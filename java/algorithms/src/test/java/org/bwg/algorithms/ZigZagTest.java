package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ZigZagTest {

    @Test
    void shouldCreateZigZagArray() {
        assertArrayEquals(new int[]{1, 2, 5, 4, 3}, doCreateZigZagArray(new int[]{2, 3, 5, 4, 1}));
        assertArrayEquals(new int[]{1, 2, 5, 4, 3}, doCreateZigZagArray(new int[]{2, 3, 5, 4, 1}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 9, 8, 7, 6, 5}, doCreateZigZagArray(new int[]{2, 9, 5, 4, 8, 6, 7, 1, 3}));
    }

    private int[] doCreateZigZagArray(int[] a) {
        int n = a.length;

        Arrays.sort(a);

        int mid = n / 2;
        int temp = a[mid];

        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2;

        while (st <= ed) {
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        return a;
    }
}
