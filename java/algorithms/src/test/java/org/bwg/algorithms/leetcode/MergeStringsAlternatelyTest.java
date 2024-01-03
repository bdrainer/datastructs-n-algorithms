package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeStringsAlternatelyTest {

    @Test
    void shouldMergeAlternately() {
        assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
        assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
        assertEquals("apbqcd", mergeAlternately("abcd", "pq"));
    }

    public String mergeAlternately(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        char[] results = new char[arr1Length + arr2Length];

        int i = 0, j = 0, k = 0;

        while (i < arr1Length && j < arr2Length) {
            if (i <= j) {
                results[k] = arr1[i];
                i++;
            } else {
                results[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1Length) {
            results[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2Length) {
            results[k] = arr2[j];
            j++;
            k++;
        }

        return new String(results);
    }
}
