package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarCipherTest {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    void shouldWork() {
//        runTest("a", 1);
//        runTest("a", 2);
//        runTest("a", 3);
//        runTest("z", 1);
//        runTest("z", 2);
//        runTest("z", 3);

        assertEquals("def", encode("abc", 3));
        assertEquals("abc", encode("xyz", 3));
        assertEquals("Wkhuh'v-d-vwdupdq", encode("There's-a-starman", 3));
    }

    void runTest(String source, int k) {
        String encode = encode(source, k);
        String decode = decode(encode, k);
        System.out.println("Source: " + source + " | encode: " + encode + " | decode: " + decode);
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
//        System.out.println("reverse character " + character);
        int idx = source.indexOf(character) - k;
        int modVal = Math.abs(source.length() + idx) % source.length();

//        System.out.println("Reverse index = " + idx);
//        System.out.println("Mod value = " + modVal);
//        System.out.println("Character.at = " + (source.length() - modVal));

        if (Math.abs(idx) > source.length()) {
            return Character.toString(source.charAt((source.length() - modVal)));
        } else {
            return Character.toString(source.charAt(modVal));
        }

    }
}
