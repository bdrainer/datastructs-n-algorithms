package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class IsSubsequenceTest {

    @Test
    void shouldWorkAsExpected() {
//        assertTrue(isSubsequence("abc", "ahbgdc"));
//        assertFalse(isSubsequence("axc", "ahbgdc"));
//        assertFalse(isSubsequence("acb", "ahbgdc"));
        assertFalse(isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while (i < sArray.length) {
            char findMe = sArray[i];
            while (j < tArray.length) {
                if (tArray[j] == findMe) {
                    sb.append(findMe);
                    j++;
                    break;
                }
                j++;
            }
            i++;
        }

        return sb.toString().equals(s);
    }
}
