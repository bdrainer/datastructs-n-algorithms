package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PalindromeIndexTest {

    @Test
    void shouldReturnIndexOfCharacterToRemoveToCreateAPalindrome() {
        assertEquals(-1, palindromeIndex("bab"));
        assertEquals(0, palindromeIndex("bcbc"));
        assertEquals(-1, palindromeIndex("caac"));
        assertEquals(3, palindromeIndex("aaab"));
        assertEquals(44, palindromeIndex("hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh"));
    }

    int palindromeIndex(String s) {
        int idx = 0;
        if (!isPalindrome(s)) {
            while (idx < s.length()) {
                if (isPalindrome(replace(s, idx))) {
                    return idx;
                }
                idx++;
            }
        }
        return -1;
    }

    String replace(String source, int idx) {
        return new StringBuilder(source).deleteCharAt(idx).toString();
    }

    boolean isPalindrome(String s) {
        return s.contentEquals(new StringBuilder(s).reverse());
    }
}
