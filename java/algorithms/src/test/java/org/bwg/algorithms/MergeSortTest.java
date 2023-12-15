package org.bwg.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MergeSortTest {

    private final MergeSort sorter = new MergeSort();

    @Test
    void shouldThrowOnNullArray() {
        assertThrows(AssertionError.class, () -> sorter.sort(null));
    }

    @Test
    void shouldSortEmptyArray() {
        sortAndAssert(new String[0], new String[0]);
    }

    @Test
    void shouldSortSingleValueArray() {
        sortAndAssert(new String[]{"a"}, new String[]{"a"});
    }

    @Test
    void shouldSortMixedCaseArray() {
        sortAndAssert(new String[]{"a", "A"}, new String[]{"a", "A"});
        sortAndAssert(new String[]{"A", "a"}, new String[]{"A", "a"});
    }

    @Test
    void shouldSortEvenNumberOfLettersArray() {
        sortAndAssert(
                new String[]{"e", "d", "c", "b"},
                new String[]{"b", "c", "d", "e"});
    }
    @Test
    void shouldSortLettersArray() {
        sortAndAssert(
                new String[]{"e", "d", "c", "b", "a"},
                new String[]{"a", "b", "c", "d", "e"});
    }

    @Test
    void shouldSortWordsArray() {
        sortAndAssert(
                new String[]{"eggs", "dough", "carrot", "bread", "apple"},
                new String[]{"apple", "bread", "carrot", "dough", "eggs"});
    }

    @Test
    void shouldSortMultiCaseWords() {
        var expected = new String[]{"APPLE", "Bread", "caRRot", "Dough", "eggS"};
        var array = new String[]{"eggS", "Dough", "caRRot", "Bread", "APPLE"};
        sortAndAssert(array, expected);
    }

    private void sortAndAssert(String[] array, String[] expected) {
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

}