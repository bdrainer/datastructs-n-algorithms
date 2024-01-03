package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompressionTest {

    @Test
    void shouldWorkAsExpected() {
        assertCompress("aabbccc", 6);
        assertCompress("abbbbbbbbbbbb", 4);
        assertCompress("aaabbaa", 6);
    }

    void assertCompress(String chars, int expectedLength) {
        char[] array = chars.toCharArray();
        assertEquals(expectedLength, compress(array));
        System.out.println(array);
    }

    public int compress(char[] chars) {
        int hi = 0;
        int lo = 0;

        while (hi < chars.length) {
            int count = 0;
            char c = chars[hi];

            while(hi < chars.length && c == chars[hi]) {
                hi++;
                count++;
            }

            chars[lo] = c;
            lo++;

            if (count > 1) {
                for (char a : String.valueOf(count).toCharArray()) {
                    chars[lo] = a;
                    lo++;
                }
            }
        }
        return lo;
    }
}
