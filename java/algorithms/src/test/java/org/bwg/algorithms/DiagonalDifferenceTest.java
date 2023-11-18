package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifferenceTest {

    @Test
    void shoudlFindDiagonalDifference() {
        List<Integer> row1 = Arrays.asList(1,2,3);
        List<Integer> row2 = Arrays.asList(4,5,6);
        List<Integer> row3 = Arrays.asList(9,8,9);

        List<List<Integer>> arr = new ArrayList<>(3);
        arr.add(row1);
        arr.add(row2);
        arr.add(row3);

        int counter = 0, leftDiag = 0, rightDiag = 0;

        while (counter < arr.size()) {
            int l = arr.get(counter).get(counter);
            int r = arr.get(counter).get(arr.size() - counter - 1);

            leftDiag += l;
            rightDiag += r;

            ++counter;
        }

        System.out.println(Math.abs(leftDiag - rightDiag));

    }
}
