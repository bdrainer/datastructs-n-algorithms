package org.bwg.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class MergeTwoSortedLinkedLists {

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, t).forEach(tItr -> {
                try {
                    if (tItr > 0) {
                        System.out.println();
                    }
                    LinkedList<Integer> list1 = new LinkedList<>();
                    LinkedList<Integer> list2 = new LinkedList<>();

                    int n = Integer.parseInt(bufferedReader.readLine().trim());

                    IntStream.range(0, n).mapToObj(i -> {
                                try {
                                    return Integer.parseInt(bufferedReader.readLine());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }).forEach(list1::add);

                    n = Integer.parseInt(bufferedReader.readLine().trim());

                    IntStream.range(0, n).mapToObj(i -> {
                                try {
                                    return Integer.parseInt(bufferedReader.readLine());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }).forEach(list2::add);

                    merge(list1, list2).forEach(val -> System.out.print(val + " "));

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
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
