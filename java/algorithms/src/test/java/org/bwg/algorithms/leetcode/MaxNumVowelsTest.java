package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxNumVowelsTest {

    @Test
    void shouldWorkAsExpected() {
        assertEquals(3, maxVowels("abciiidef", 3));
        assertEquals(2, maxVowels("aeiou", 2));
        assertEquals(2, maxVowels("leetcode", 3));
        assertEquals(4, maxVowels("weallloveyou", 7));
    }

    public int maxVowels(String s, int k) {
        Set<Character> Vowels = Set.of('a', 'e', 'i', 'o', 'u');

        int max;
        int tracker = 0;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < k; i++) {
            if (Vowels.contains(charArray[i])) {
                tracker++;
            }
        }

        max = tracker;

        for (int i = 1; i <= charArray.length - k ; i++) {
            if (!Vowels.contains(charArray[i - 1]) && Vowels.contains(charArray[i + k - 1])) {
                tracker++;
            } else if (Vowels.contains(charArray[i - 1]) && !Vowels.contains(charArray[i + k - 1])) {
                tracker--;
            }
            if (max < tracker) {
                max = tracker;
            }
        }

        return max;
    }
}
