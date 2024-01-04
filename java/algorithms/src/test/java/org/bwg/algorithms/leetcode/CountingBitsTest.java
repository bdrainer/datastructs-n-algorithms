package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CountingBitsTest {

    @Test
    void shouldWorkAsExpected() {
//        assertArrayEquals(new int[]{0, 1, 1}, countBits(2));
//        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countBits(5));
//        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countBits(5));
//
//        System.out.println("3 : " + Integer.toBinaryString(3) + " | 1 : " + Integer.toBinaryString(2));
//        System.out.println(3 & (3-1));

        System.out.println(Arrays.toString(countBits(12)));

    }

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            System.out.println("temp = " + i);
            int temp = i;
            int count = 0;
            while (temp != 0) {
                System.out.println("Pre: "  + temp + " | binary : " + Integer.toBinaryString(temp));
                temp = temp & (temp - 1);
                System.out.println("Post: "  + temp);
                count++;
            }
            arr[i] = count;
        }
        return arr;
    }

    public int[] countBits2(int n) {
        int[] results = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            results[i] = Integer.toBinaryString(i).replace("0", "").length();
        }
        return results;
    }
}
