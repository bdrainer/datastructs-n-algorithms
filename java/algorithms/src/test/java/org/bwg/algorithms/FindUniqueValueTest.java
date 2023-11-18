package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindUniqueValueTest {

    @Test
    void shouldFindUniqueValueInArray() {
        int[] a = new int[]{1, 2, 3, 1, 2, 3, 4};

        Map<Integer, Integer> tracker = new HashMap<>();

        for (int key : a) {
            if (tracker.containsKey(key)) {
                tracker.replace(key, tracker.get(key) + 1);
            } else {
                tracker.put(key, 1);
            }
        }

        int result = 0;

        Set<Integer> keys = tracker.keySet();
        for (Integer key : keys) {
            if (tracker.get(key) == 1) {
                result = key;
                break;
            }
        }

        assertEquals(4, result);
    }
}
