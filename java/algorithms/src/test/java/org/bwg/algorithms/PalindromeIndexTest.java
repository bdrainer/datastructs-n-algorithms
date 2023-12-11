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
        String r = new StringBuilder(s).reverse().toString();
        while (idx < s.length()) {
            if (s.charAt(idx) != r.charAt(idx)) {

                if (isPalindrom(replace(s, idx))) {
                    return idx;
                } else if (isPalindrom(replace(r, idx))) {
                    return s.length() - 1 - idx;
                }
            }
            idx++;
        }
        return -1;
    }

    String replace(String source, int idx) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i != idx) {
                b.append(source.charAt(i));
            }
        }
        return b.toString();
    }

    boolean isPalindrom(String s) {
        String r = new StringBuilder(s).reverse().toString();
        return s.equals(r);
    }
}
