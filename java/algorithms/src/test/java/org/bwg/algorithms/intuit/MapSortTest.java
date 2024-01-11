package org.bwg.algorithms.intuit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapSortTest {

    @Test
    void shouldSortLinkedHashMap() {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("y", 2);
        map.put("z", 1);
        map.put("x", 3);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.forEach(e -> System.out.printf("Key: %s, Value: %d%n",  e.getKey(), e.getValue()));
        System.out.println("------");

//        list.sort((e1, e2) -> e1.getValue() - e2.getValue());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));
        list.forEach(e -> System.out.printf("Key: %s, Value: %d%n",  e.getKey(), e.getValue()));
        System.out.println("------");

//        list.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
        list.sort(Map.Entry.comparingByKey());
        list.forEach(e -> System.out.printf("Key: %s, Value: %d%n",  e.getKey(), e.getValue()));
        System.out.println("------");

        List<Map.Entry<String, Integer>> top = list.stream().limit(1).toList();
        top.forEach(e -> System.out.printf("Key: %s, Value: %d%n",  e.getKey(), e.getValue()));
    }
}
