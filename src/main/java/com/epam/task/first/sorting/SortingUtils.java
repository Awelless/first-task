package com.epam.task.first.sorting;

import java.util.List;

public class SortingUtils {

    public static void switchSign(List<Integer> elements) {

        for (int i = 0; i < elements.size(); ++i) {
            Integer value = elements.get(i);
            elements.set(i, -value);
        }

    }
}
