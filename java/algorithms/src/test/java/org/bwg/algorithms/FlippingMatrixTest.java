package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * The goal is to move the largest numbers into the upper left quadrant of a matrix but only by flipping a column
 * or row.  You can flip any row and any column.  You can flip them as many times as you want.  The matrix will always
 * be a square with even length and width: examples are 2x2, 4x4, 6x6, 8x8.  The exercise asks to sum up the values
 * in the upper left quadrant.  This sum should be the max value one can get when flipping the values into the
 * upper left quadrant.
 *
 * The simplest example
 * <p>
 * <table>
 *     <tr><td>1</td><td>2</td></tr>
 *     <tr><td>3</td><td>4</td></tr>
 * </table>
 * </p>
 * <p>
 * The result is 4.
 * </p>
 * <p>
 * This is the example given in the exercise.
 * <table>
 *     <tr><td>112</td><td>42</td><td>83</td><td>119</td></tr>
 *     <tr><td>56</td><td>125</td><td>56</td><td>49</td></tr>
 *     <tr><td>15</td><td>78</td><td>101</td><td>43</td></tr>
 *     <tr><td>62</td><td>98</td><td>114</td><td>108</td></tr>
 * </table>
 * </p>
 * <p>
 * First, flip the 3rd column.
 * <table>
 *     <tr><td>112</td><td>42</td><td>114</td><td>119</td></tr>
 *     <tr><td>56</td><td>125</td><td>101</td><td>49</td></tr>
 *     <tr><td>15</td><td>78</td><td>56</td><td>43</td></tr>
 *     <tr><td>62</td><td>98</td><td>83</td><td>108</td></tr>
 * </table>
 * </p>
 * <p>
 * Second, flip the 1st row.
 * <table>
 *     <tr><td>119</td><td>114</td><td>42</td><td>112</td></tr>
 *     <tr><td>56</td><td>125</td><td>101</td><td>49</td></tr>
 *     <tr><td>15</td><td>78</td><td>56</td><td>43</td></tr>
 *     <tr><td>62</td><td>98</td><td>83</td><td>108</td></tr>
 * </table>
 * </p>
 * <p>
 * This is the solution where 119 + 114 + 56 + 125 = 414 and 414 is the largest sum one can get with flipping
 * rows and columns.
 * </p>
 * <p>
 * The solution is seeing that a position can be one of four values.  Take the corners.  The upper left can be replaced
 * by the upper right, the lower left, and the lower right.  This is same for all the upper left quadrant positions.
 * </p>
 * <p>
 * The pattern formed is in a 4x4 matrix is below.  Find the largest A, largest B, largest C, and largest D.  Then add
 * them up to get the result.
 *  * <table>
 *  *     <tr><td>A</td><td>B</td><td>B</td><td>A</td></tr>
 *  *     <tr><td>C</td><td>D</td><td>D</td><td>C</td></tr>
 *  *     <tr><td>C</td><td>D</td><td>D</td><td>C</td></tr>
 *  *     <tr><td>A</td><td>B</td><td>B</td><td>A</td></tr>
 *  * </table>
 * </p>
 *
 */
public class FlippingMatrixTest {

    /**
     * The exercise typically gives a List.  I like to convert that to an array and swap directly on the array.
     * The exercise was using Java 8, but I prefer to use whatever the latest Java version there is.
     */
    @Test
    void shouldFlipMatrix() {
        // 4 x 4 matrix
        List<List<Integer>> matrix = List.of(
                List.of(112, 42, 83, 119),
                List.of(56, 125, 56, 49),
                List.of(15, 78, 101, 43),
                List.of(62, 98, 114, 108)
        );
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
