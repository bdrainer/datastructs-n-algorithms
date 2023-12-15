package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinMaxSumTest {

    @Test
    void shouldCalculateMinMaxSum() {
        assertArrayEquals(new int[] {10, 14}, miniMaxSum(List.of(1,2,3,4,5)));
        assertArrayEquals(new int[] {16, 24}, miniMaxSum(List.of(1,3,5,7,9)));
    }

    public static int[] miniMaxSum(List<Integer> list) {
        Integer[] array = list.toArray(new Integer[0]);
        Arrays.sort(array);

        int min = 0, max = 0;

        for (int i = 0; i < array.length - 1; i++) {
            min += array[i];
            max += array[array.length - 1 - i];
        }

        return new int[] {min, max};
    }
}
