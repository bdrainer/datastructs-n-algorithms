package org.bwg.datastructures;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedHashMapTest {

    @Test
    void should_use_linked_hashmap_as_a_least_recently_used_cache() {

    }

    /**
     * Use a LinkedHashNap and confirm the insertion order is maintained when iterating over the key set and entry set.
     */
    @Test
    void given_a_linked_hashmap_when_getting_keys_they_should_be_ordered_by_insertion_order() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        Integer[] keys = map.keySet().toArray(new Integer[0]);

        for (int i = 0; i < keys.length; i++) {
            assertEquals(i + 1, keys[i]);
        }

        int count = 0;
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            assertEquals(count + 1, entry.getKey());
            ++count;
        }
    }
}
