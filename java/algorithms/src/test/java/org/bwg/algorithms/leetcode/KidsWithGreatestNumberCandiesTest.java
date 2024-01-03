package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithGreatestNumberCandiesTest {

    @Test
    void shouldFindAnswer() {

        Assertions.assertArrayEquals(
                new Boolean[]{Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE},
                kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3).toArray(new Boolean[0]));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> results = new ArrayList<>();

        int max = Arrays.stream(candies).max().getAsInt();

        for (int candy : candies) {
            results.add(candy + extraCandies >= max
                    ? Boolean.TRUE
                    : Boolean.FALSE);
        }

        return results;
    }
}
