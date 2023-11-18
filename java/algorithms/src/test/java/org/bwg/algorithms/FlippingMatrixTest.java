package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlippingMatrixTest {

    @Test
    void shouldFlipMatrix() {
        List<List<Integer>> matrix = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>(Arrays.asList(112, 42, 83, 119));
        List<Integer> row2 = new ArrayList<>(Arrays.asList(56, 125, 56, 49));
        List<Integer> row3 = new ArrayList<>(Arrays.asList(15, 78, 101, 43));
        List<Integer> row4 = new ArrayList<>(Arrays.asList(62, 98, 114, 108));

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        matrix.add(row4);

//        int[] row1 = new int[]{112, 42, 83, 119};
//        int[] row2 = new int[]{56, 125, 56, 49};
//        int[] row3 = new int[]{15, 78, 101, 43};
//        int[] row4 = new int[]{62, 98, 114, 108};

//        int[][] matrix = new int[4][4];
//
//        matrix[0] = row1;
//        matrix[1] = row2;
//        matrix[2] = row3;
//        matrix[3] = row4;

        int result = doFlipMatrix(matrix);
        System.out.println(result);
    }

    private int doFlipMatrix(List<List<Integer>> matrix) {
        int[][] a = new int[matrix.size()][matrix.size()];

        for (int i = 0; i < matrix.size(); ++i) {
            List<Integer> row = matrix.get(i);
            for (int j = 0; j < row.size(); ++j) {
                a[i][j] = row.get(j);
            }
        }

        int n = a.length;
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                sum += max(
                        a[i][j],
                        a[i][n - j - 1],
                        a[n - i - 1][j],
                        a[n - i - 1][n - j - 1]);
            }
        }

        return sum;
    }

    private int max(int... vals) {
        Arrays.sort(vals);
        return vals[vals.length - 1];

    }
}
