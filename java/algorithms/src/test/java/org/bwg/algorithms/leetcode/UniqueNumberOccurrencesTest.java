package org.bwg.algorithms.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueNumberOccurrencesTest {

    @Test
    void shouldFindExpectedOccurrences() {
        assertTrue(uniqueOccurrences(new int[] {1,2,2,1,1,3}));

    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : arr) {
            map.merge(num, 1, Integer::sum);
        }

        Set<Integer> counts = new HashSet<>();
        for (Map.Entry<Integer, Integer> entries : map.entrySet()) {
            if (counts.contains(entries.getValue())) {
                return false;
            }
            counts.add(entries.getValue());
        }

        return true;
    }
}
