package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsTest {

    @Test
    void shouldReverseWords() {
        assertEquals("blue is sky the", reverseWords("the sky is blue"));
        assertEquals("world hello", reverseWords("  hello world  "));
        assertEquals("example good a", reverseWords("a good  example"));
    }


    String reverseWords(String input) {
        String[] split = input.split(" ");
        StringBuilder b = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isBlank()) {
                b.append(" ").append(split[i].trim());
            }
        }
        return b.toString().trim();
    }
}
