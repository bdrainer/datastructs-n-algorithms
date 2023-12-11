package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridChallengeTest {


    @Test
    void shouldConfirmIfGridIsAlphabetizedOrNot() {
        assertEquals("YES", gridChallenge(
                List.of(
                        "abc",
                        "hjk",
                        "mpq",
                        "rtv"
                )));
        assertEquals("NO", gridChallenge(
                List.of(
                        "abc",
                        "efg",
                        "ade"
                )));

    }

    String gridChallenge(List<String> grid) {
        int rows = grid.size();
        int columns = grid.get(0).length();

        List<String> sortedGrid = new ArrayList<>(grid.size());

        for (String val : grid) {
            char[] charArray = val.toCharArray();
            Arrays.sort(charArray);
            sortedGrid.add(new String(charArray));
        }

        int i = 0;
        while (i < rows - 1) {
            int j = 0;
            while (j < columns) {
                System.out.printf("Compare %s with %s%n", sortedGrid.get(i).charAt(j), sortedGrid.get(i + 1).charAt(j));
                if (sortedGrid.get(i).charAt(j) > sortedGrid.get(i + 1).charAt(j)) {
                    return "NO";
                }
                j++;
            }
            i++;
        }
        return "YES";
    }
}
