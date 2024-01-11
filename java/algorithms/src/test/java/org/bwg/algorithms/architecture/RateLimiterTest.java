package org.bwg.algorithms.architecture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RateLimiterTest {

    @Test
    void shouldPassLeetCodeBasicUseCase() {
        RateLimiter limiter = new RateLimiter(3, 5);
        assertTrue(limiter.shouldAllow(1));
        assertTrue(limiter.shouldAllow(1));
        assertTrue(limiter.shouldAllow(2));
        assertFalse(limiter.shouldAllow(3));
        assertTrue(limiter.shouldAllow(8));
    }

    @Test
    void shouldPassLeetCodeAcceptanceTest() {
        RateLimiter limiter = new RateLimiter(16, 12);

        // 3 entries of timestamps less than 50
        // 50 - 38 = 12
        assertTrue(limiter.shouldAllow(38));
        assertTrue(limiter.shouldAllow(42));
        assertTrue(limiter.shouldAllow(48));

        // 14 entries of timestamp 50
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));
        assertTrue(limiter.shouldAllow(50));

        assertFalse(limiter.shouldAllow(50));
        assertFalse(limiter.shouldAllow(50));
    }
}
