package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperDigitTest {

    @Test
    void shouldCalculateSuperDigit() {
        assertEquals(4, superDigit("9875", 2));
        assertEquals(8, superDigit("9875987598759875", 1));
    }

    int superDigit(String n, int k) {
        BigInteger sd = new BigInteger("0");
        for(int i = 0; i < n.length(); i++) {
            sd = sd.add(new BigInteger(Character.toString(n.charAt(i))));
        }
        sd = sd.multiply(BigInteger.valueOf(k));
        return sd.longValue() < 10L ? sd.intValue() : superDigit(sd.toString(), 1);
    }
}
