package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DifferenceBetweenTwoArraysTest {

    @Test
    void shouldFindDifferences() {
        List<List<Integer>> difference;

        difference = findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});
        assertArrayEquals(new Integer[]{1, 3}, difference.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[]{4, 6}, difference.get(1).toArray(new Integer[0]));

        difference = findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2});
        assertArrayEquals(new Integer[]{3}, difference.get(0).toArray(new Integer[0]));
        assertArrayEquals(new Integer[0], difference.get(1).toArray(new Integer[0]));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }

        Integer[] nums1Int = set1.toArray(new Integer[0]);
        Integer[] nums2Int = set2.toArray(new Integer[0]);

        List<Integer> diff1 = new ArrayList<>();
        List<Integer> diff2 = new ArrayList<>();

        for (Integer n : nums1Int) {
            if (!set2.contains(n)) {
                diff1.add(n);
            }
        }

        for (Integer n : nums2Int) {
            if (!set1.contains(n)) {
                diff2.add(n);
            }
        }

        return List.of(diff1, diff2);
    }
}
