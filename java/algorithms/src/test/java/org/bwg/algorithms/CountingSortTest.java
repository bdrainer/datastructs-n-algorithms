package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The exercise is asking to count the number of times the same value is seen in an array.  The idea is this can be used
 * to sort the array.  The exercise limits the values that can be in the array.  The range is from 0 to 99.
 */
public class CountingSortTest {

    private static final int MAX_SIZE = 100;

    @Test
    void shouldCountSort() {
        List<Integer> values = Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96, 27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30, 20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70, 33);
        List<Integer> results = doCountSort(values);
        System.out.println(results);
    }

    private List<Integer> doCountSort(List<Integer> arr) {
        List<Integer> results = new ArrayList<>(MAX_SIZE);
        for (int i = 0; i < MAX_SIZE; ++i) {
            results.add(0);
        }
        for (int i : arr) {
            results.set(i, results.get(i) + 1);
        }
        return results;
    }
}
