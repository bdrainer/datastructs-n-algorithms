package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreatestCommonDivisorTest {

    @Test
    void shouldFindGCD() {
        assertEquals("AB", gcdOfStrings("AB", "AB"));
        assertEquals("ABC", gcdOfStrings("ABCABC", "ABC"));
        assertEquals("AB", gcdOfStrings("ABABAB", "ABAB"));
        assertEquals("AB", gcdOfStrings("ABAB", "ABABAB"));
        assertEquals("A", gcdOfStrings("AAAAAA", "A"));
        assertEquals("", gcdOfStrings("LEET", "CODE"));
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return gcdOfStrings(str2, str1);
        }
        if (str1.equals(str2)) {
            return str1;
        }
        if (str1.startsWith(str2)) {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
        return "";
    }
}
