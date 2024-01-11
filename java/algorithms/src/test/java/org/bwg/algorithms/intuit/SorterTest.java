package org.bwg.algorithms.intuit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SorterTest {

    public static class Profile implements Comparable<Profile> {
        final String name;
        final int temp;
        final int pressure;
        final int humidity;

        Profile(String name, int temp, int pressure, int humidity) {
            this.name = name;
            this.temp = temp;
            this.pressure = pressure;
            this.humidity = humidity;
        }

        public int getHumidity() {
            return humidity;
        }

        @Override
        public String toString() {
            return String.format("name: %s | temp: %d | pressure: %d | humidity: %d",
                    name, temp, pressure, humidity);
        }

        @Override
        public int compareTo(Profile profile) {
            return this.name.compareTo(profile.name);
        }
    }

    @Test
    void shouldSortListOfProfiles() {
        List<Profile> list = new ArrayList<>();
        list.add(new Profile("Forty", 40, 40, 40));
        list.add(new Profile("Fifty", 50, 50, 50));
        list.add(new Profile("Twenty", 20, 20, 20));
        list.add(new Profile("Thirty", 30, 30, 30));
        list.add(new Profile("Ten", 10, 10, 10));

        Collections.sort(list);
        System.out.println(list);

        list.sort(Comparator.comparingInt(Profile::getHumidity).reversed());

        List<Profile> profiles = list.stream().limit(3).toList();
//        List<Profile> profiles = list.stream().limit(3).collect(Collectors.toList());
//        List<Profile> profiles = list.subList(0, 3);
        System.out.println(profiles);

        list.sort((o1, o2) -> {
            if (o1.temp < o2.temp) {
                return -1;
            } else if (o1.temp > o2.temp) {
                return 1;
            } else {
                if (o1.pressure < o2.pressure) {
                    return -1;
                } else if (o1.pressure > o2.pressure) {
                    return 1;
                } else {
                    if (o1.humidity < o2.humidity) {
                        return -1;
                    } else if (o1.humidity > o2.humidity) {
                        return 1;
                    }
                    return 0;
                }
            }
        });

        System.out.println(list);
    }

    @Test
    void shouldSortIntegers() {
        List<String> sortedStrings = Stream.of("foo", "test", "a")
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(Collectors.toList());

        System.out.println(sortedStrings);
        Collections.reverse(sortedStrings);
        System.out.println(sortedStrings);

        Integer[] arr = new Integer[]{4, 3, 5, 2, 1};
        Arrays.sort(arr);

        List<Integer> times2 = Arrays.stream(arr).map(integer -> integer * 2).toList();
        System.out.println("Times 2: " + times2);

        List<Integer> list = Arrays.asList(arr);

        list.sort(Comparator.comparingInt(o -> o));
        list.sort(Comparator.comparingInt(o -> (Integer) o).reversed());

        System.out.println(list);
    }
}