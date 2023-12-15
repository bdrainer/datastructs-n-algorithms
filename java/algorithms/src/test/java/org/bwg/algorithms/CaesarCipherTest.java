package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    void shouldWork() {
        runTest("a", "a", 0);
        runTest("a", "a", 26);
        runTest("a", "a", 52);
        runTest("b", "b", 0);
        runTest("b", "b", 26);
        runTest("b", "b", 52);
        runTest("c", "c", 0);
        runTest("c", "c", 26);
        runTest("c", "c", 52);
        runTest("x", "x", 0);
        runTest("x", "x", 26);
        runTest("x", "x", 52);
        runTest("y", "y", 0);
        runTest("y", "y", 26);
        runTest("y", "y", 52);
        runTest("z", "z", 0);
        runTest("z", "z", 26);
        runTest("z", "z", 52);

        runTest("def", "abc", 3);
        runTest("abc", "xyz", 3);
        runTest("Wkhuh'v-d-vwdupdq", "There's-a-starman", 3);
    }

    void runTest(String expected, String value, int k) {
        String encode = encode(value, k);
        assertEquals(expected, encode);
        assertEquals(value, decode(encode, k));
    }

    String encode(String s, int k) {
        StringBuilder b = new StringBuilder();
        s.chars().mapToObj(c -> Character.toString((char) c))
                .map(str -> LOWER.contains(str)
                        ? shift(LOWER, str, k)
                        : UPPER.contains(str)
                        ? shift(UPPER, str, k)
                        : str
                )
                .forEach(b::append);
        return b.toString();
    }

    String decode(String s, int k) {
        StringBuilder b = new StringBuilder();
        s.chars().mapToObj(c -> Character.toString((char) c))
                .map(str -> LOWER.contains(str)
                        ? reverserShift(LOWER, str, k)
                        : UPPER.contains(str)
                        ? reverserShift(UPPER, str, k)
                        : str
                )
                .forEach(b::append);
        return b.toString();
    }

    String shift(String source, String character, int k) {
        return Character.toString(source.charAt((source.indexOf(character) + k) % source.length()));
    }

    String reverserShift(String source, String character, int k) {
        int idx = source.indexOf(character) - k;
        int modVal = Math.abs(source.length() + idx) % source.length();

        if (modVal != 0 && Math.abs(idx) > source.length()) {
            return Character.toString(source.charAt((source.length() - modVal)));
        } else {
            return Character.toString(source.charAt(modVal));
        }
    }
}
