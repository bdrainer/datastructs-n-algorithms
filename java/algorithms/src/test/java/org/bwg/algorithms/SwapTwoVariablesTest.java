package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * I was asked how to swap two values.  The person specifically asked how to do it without using a third
 * variable.  Their answer was to use XOR, but I am still unsure how to do that without a third variable.
 * XOR
 */
public class SwapTwoVariablesTest {

    private static final int THREE = 3;
    private static final int SEVEN = 7;

    /**
     * Using XOR is one way to do this but there must be a third variable if the goal is to reassign the values.
     */
    @Test
    void shouldSwapTwoIntegerVariablesUsingXOR() {
        int a = THREE, b = SEVEN;
        assertEquals(SEVEN, (a ^ (a ^ b)));
        assertEquals(THREE, (b ^ (a ^ b)));

        char y = 'y', z = 'z';

        assertEquals('z', (y ^ (y ^ z)));
        assertEquals('y', (z ^ (z ^ y)));
    }

    /**
     * Using addition and subtraction works with integers works.
     */
    @Test
    void shouldSwapTwoIntegerVariablesUsingAdditionsSubtraction() {
        int a = 3, b = 7;
        a = a + b;
        b = a - b;
        a = a - b;
        assertEquals(7, a);
        assertEquals(3, b);
    }
}
