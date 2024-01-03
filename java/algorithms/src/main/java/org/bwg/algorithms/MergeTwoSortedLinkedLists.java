package org.bwg.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * Merge two sorted linked lists.
 * <p>
 * Input format:
 * <pre>
 * t - the number of test cases
 * n - length of first linked list
 * next n lines contains the values for the first linked list, these values must be sorted
 * m - length of second linked list
 * next m lines contains the value for the second linked list, these values must be sorted
 * </pre>
 * </p>
 * <p>
 * Example input:
 * <pre>
 * 1 - one test case
 * 3 - linked list 1 has 3 integers
 * 1 - value 1 of linked list 1
 * 2 - value 2 of linked list 1
 * 3 - value 3 of linked list 1
 * 2 - linked list 2 has 2 integers
 * 3 - value 1 of linked list 2
 * 4 - value 2 of linked list 2
 * </pre>
 * <p>
 * Expected output
 * <pre>1 2 3 3 4</pre>
 * </p>
 */
public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    if (tItr > 0) {
                        System.out.println();
                    }

                    int n = Integer.parseInt(bufferedReader.readLine().trim());
                    LinkedList<Integer> list1 = readIntegers(bufferedReader, n);

                    n = Integer.parseInt(bufferedReader.readLine().trim());
                    LinkedList<Integer> list2 = readIntegers(bufferedReader, n);

                    merge(list1, list2).forEach(val -> System.out.print(val + " "));

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

    /**
     * Reads an integer from the input where eadh integer is on a newline.  The range defines the number of lines to
     * read.
     */
    static LinkedList<Integer> readIntegers(BufferedReader bufferedReader, int range) {
        LinkedList<Integer> list = new LinkedList<>();

        IntStream.range(0, range).mapToObj(i -> {
            try {
                return Integer.parseInt(bufferedReader.readLine());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }).forEach(list::add);

        return list;
    }

    static LinkedList<Integer> merge(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        if (l1 == null || l1.isEmpty()) {
            return l2;
        }
        if (l2 == null || l2.isEmpty()) {
            return l1;
        }

        LinkedList<Integer> result = new LinkedList<>();
        if (l1.getFirst() <= l2.getFirst()) {
            result.add(l1.removeFirst());
            result.addAll(merge(l1, l2));
        } else if (l2.getFirst() < l1.getFirst()) {
            result.add(l2.removeFirst());
            result.addAll(merge(l1, l2));
        }
        return result;
    }
}
