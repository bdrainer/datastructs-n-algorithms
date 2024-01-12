package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetermineIfTwoStringsAreCloseTest {

    @Test
    void shouldWorkAsExpected() {
        assertTrue(closeStrings("abc", "bca"));
        assertTrue(closeStrings("cabbba", "abbccc"));
        assertFalse(closeStrings("a", "aa"));
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for (final char c : word1.toCharArray())
            count1.merge(c, 1, Integer::sum);

        for (final char c : word2.toCharArray())
            count2.merge(c, 1, Integer::sum);

        if (!count1.keySet().equals(count2.keySet()))
            return false;

        List<Integer> freqs1 = new ArrayList<>(count1.values());
        List<Integer> freqs2 = new ArrayList<>(count2.values());

        Collections.sort(freqs1);
        Collections.sort(freqs2);
        return freqs1.equals(freqs2);
    }
}
