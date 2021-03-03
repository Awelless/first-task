package com.epam.task.first.sorting;

import com.epam.task.first.entity.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayQuickSorter implements ArraySorter {

    private void sortSubarray(List<Integer> list, int lBound, int rBound) {

        if (rBound - lBound <= 0) {
            return;
        }

        int lPosition = lBound;
        int rPosition = rBound;

        Integer pivot = list.get(lPosition);

        boolean isPivotOnRight = false;

        while(rPosition - lPosition > 0) {
            
            if (isPivotOnRight) {

                Integer lValue = list.get(lPosition);

                if (lValue > pivot) {

                    Collections.swap(list, lPosition, rPosition);
                    isPivotOnRight = false;
                    rPosition--;

                } else {
                    lPosition++;
                }
            } else {

                Integer rValue = list.get(rPosition);

                if (pivot > rValue) {

                    Collections.swap(list, lPosition, rPosition);
                    isPivotOnRight = true;
                    lPosition++;

                } else {
                    rPosition--;
                }
            }
        }

        sortSubarray(list, lBound, lPosition - 1);
        sortSubarray(list, rPosition + 1, rBound);
    }

    @Override
    public Array sort(final Array array, final SortType sortType) {

        List<Integer> elements = new ArrayList<>(array.getElements());

        if (sortType.equals(SortType.DESCENDING)) {
            SortingUtils.switchSign(elements);
        }

        int lastPosition = elements.size() - 1;

        sortSubarray(elements, 0, lastPosition);

        if (sortType.equals(SortType.DESCENDING)) {
            SortingUtils.switchSign(elements);
        }

        return new Array(elements);
    }
}
