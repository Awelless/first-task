package com.epam.task.first.sorting;

import com.epam.task.first.entity.Array;
import org.junit.Assert;
import org.junit.Test;

public class ArraySorterTest {

    private final ArraySorter quickSorter     = new ArrayQuickSorter();
    private final ArraySorter bubbleSorter    = new ArrayBubbleSorter();
    private final ArraySorter selectionSorter = new ArraySelectionSorter();

    private static final Array ARRAY = new Array(0, 2, -1, 1, -3, -2, 3);

    private static final Array EXPECTED_ASCENDING  = new Array(-3, -2, -1,  0,  1,  2,  3);
    private static final Array EXPECTED_DESCENDING = new Array( 3,  2,  1,  0, -1, -2, -3);

    @Test
    public void testQuickSorterSortShouldSortAscendingAllElements() {
        Array result = quickSorter.sort(ARRAY, SortType.ASCENDING);

        Assert.assertEquals(EXPECTED_ASCENDING, result);
    }

    @Test
    public void testQuickSorterSortShouldSortDescendingAllElements() {
        Array result = quickSorter.sort(ARRAY, SortType.DESCENDING);

        Assert.assertEquals(EXPECTED_DESCENDING, result);
    }

    @Test
    public void testBubbleSorterSortShouldSortAscendingAllElements() {
        Array result = bubbleSorter.sort(ARRAY, SortType.ASCENDING);

        Assert.assertEquals(EXPECTED_ASCENDING, result);
    }

    @Test
    public void testBubbleSorterSortShouldSortDescendingAllElements() {
        Array result = bubbleSorter.sort(ARRAY, SortType.DESCENDING);

        Assert.assertEquals(EXPECTED_DESCENDING, result);
    }

    @Test
    public void testSelectionSorterSortShouldSortAscendingAllElements() {
        Array result = selectionSorter.sort(ARRAY, SortType.ASCENDING);

        Assert.assertEquals(EXPECTED_ASCENDING, result);
    }

    @Test
    public void testSelectionSorterSortShouldSortDescendingAllElements() {
        Array result = selectionSorter.sort(ARRAY, SortType.DESCENDING);

        Assert.assertEquals(EXPECTED_DESCENDING, result);
    }
}
