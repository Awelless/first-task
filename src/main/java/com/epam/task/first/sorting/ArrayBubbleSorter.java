package com.epam.task.first.sorting;

import com.epam.task.first.entity.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayBubbleSorter implements ArraySorter {

    @Override
    public Array sort(final Array array, SortType sortType) {
        List<Integer> elements = new ArrayList<>(array.getElements());

        if (sortType.equals(SortType.DESCENDING)) {
            SortingUtils.switchSign(elements);
        }

        for (int iteration = 0; iteration < elements.size(); ++iteration) {
            for (int i = 0; i + 1 < elements.size() - iteration; ++i) {

                int currentValue = elements.get(i);
                int nextValue    = elements.get(i + 1);

                if (currentValue > nextValue) {
                    Collections.swap(elements, i, i + 1);
                }
            }
        }

        if (sortType.equals(SortType.DESCENDING)) {
            SortingUtils.switchSign(elements);
        }

        return new Array(elements);
    }
}
