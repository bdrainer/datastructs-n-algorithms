package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVowelsOfAStringTest {

    @Test
    void shouldReverseVowels() {
        assertEquals("holle", reverseVowels("hello"));
        assertEquals("leotcede", reverseVowels("leetcode"));
        assertEquals("abcd", reverseVowels("abcd"));
        assertEquals("bcd", reverseVowels("bcd"));
        assertEquals("", reverseVowels(""));
    }

    public String reverseVowels(String s) {
        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        char[] arr = s.toCharArray();

        // collect vowels
        StringBuilder found = new StringBuilder();
        for (char a : arr) {
            if (vowels.contains(a)) {
                found.append(a);
            }
        }

        // reverse vowels
        char[] reversed = found.reverse().toString().toCharArray();

        // replace vowels
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            char a = arr[i];
            if (vowels.contains(a)) {
                arr[i] = reversed[count];
                count++;
            }
        }

        return new String(arr);
    }
}
