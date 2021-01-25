package com.epam.task.first.sorting;

import com.epam.task.first.entity.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraySelectionSorter implements ArraySorter {

    @Override
    public Array sort(final Array array, SortType sortType) {

        List<Integer> elements = new ArrayList<>(array.getElements());

        if (sortType.equals(SortType.DESCENDING)) {
            SortingUtils.switchSign(elements);
        }

        for (int i = 0; i < elements.size(); ++i) {
            for (int j = i + 1; j < elements.size(); ++j) {

                Integer iValue = elements.get(i);
                Integer jValue = elements.get(j);

                if (iValue > jValue) {
                    Collections.swap(elements, i, j);
                }
            }
        }

        if (sortType.equals(SortType.DESCENDING)) {
            SortingUtils.switchSign(elements);
        }

        return new Array(elements);
    }
}
