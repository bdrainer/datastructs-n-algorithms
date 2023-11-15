package org.bwg.datastructures;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedHashMapTest {

    @Test
    void given_a_linked_hashmap_when_getting_keys_they_should_be_ordered_by_insertion_order() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "one");
        map.put(2, "three");
        map.put(3, "two");

        Integer[] keys = map.keySet().toArray(new Integer[0]);

        for (int i = 0; i < keys.length; i++) {
            assertEquals(i+1, keys[i]);
        }

    }
}
