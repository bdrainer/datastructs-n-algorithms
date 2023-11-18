package org.bwg.datastructures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {

    /**
     * Sort an array of integers.
     */
    @Test
    void shouldSortArray() {
        int[] expected = new int[]{1, 2, 3, 4, 5};
        int[] array = new int[]{5, 4, 3, 2, 1};
        Arrays.sort(array);
        assertArrayEquals(expected, array);
    }

    /**
     * Calculate the ratio of the positive, negative, and zero numbers in the list.  Print the ration out to the 6th
     * decimal place.
     */
    @Test
    void testPosNegZeroRatio() {
        List<Integer> arr = List.of(1, -2, -7, 9, 1, -8, -5);

        double size = arr.size();

        int pos = 0, neg = 0, zero = 0;

        for (int val : arr) {
            if (val > 0 && val <= 100) {
                ++pos;
            } else if (val < 0 && val >= -100) {
                ++neg;
            } else {
                ++zero;
            }
        }

        assertEquals("0.428571", String.format("%7.6f", pos / size));
        assertEquals("0.571429", String.format("%7.6f", neg / size));
        assertEquals("0.000000", String.format("%7.6f", zero / size));
    }

    /**
     * Given a list calculate the min sum by excluding the max value, and calculate the max sum by excluding the min
     * value.  One condition is the list will never contain a duplicate value.
     */
    @Test
    public void testMinMaxSum() {
        List<Integer> list = new ArrayList<>(List.of(5, 3, 1, 2, 4));

        // sort the list from lowest value to highest value
        Collections.sort(list);

        // exclude the last value when calculating the sum
        int lowVal = list.stream().limit(list.size() - 1).reduce(0, Integer::sum);
        // skip the first value when calculating the sum
        int highVal = list.stream().skip(1).reduce(0, Integer::sum);

        assertEquals(10, lowVal);
        assertEquals(14, highVal);
    }

    @Test
    void testMedian() {
        List<Integer> list = Arrays.asList(5,3,1,2,4);
        Integer[] arr = list.toArray(new Integer[0]);
        Arrays.sort(arr);
        int median = arr.length / 2;
        assertEquals(3, arr[median]);
    }
}
