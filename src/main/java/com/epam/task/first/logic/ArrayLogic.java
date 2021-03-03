package com.epam.task.first.logic;

import com.epam.task.first.entity.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayLogic {

    private void checkArray(final Array array) {
        if (array == null) {
            throw new IllegalArgumentException("Array argument mustn't be null");
        }

        List<Integer> elements = array.getElements();

        if (elements.size() == 0) {
            throw new IllegalArgumentException("Array argument mustn't be empty");
        }
    }

    public int findMin(final Array array) {
        checkArray(array);

        List<Integer> elements = array.getElements();

        int min = elements.get(0);

        for (Integer element : elements) {
            if (element < min) {
                min = element;
            }
        }

        return min;
    }

    public int findMax(final Array array) {
        checkArray(array);

        List<Integer> elements = array.getElements();

        int max = elements.get(0);

        for (Integer element : elements) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

    public Array replaceByPredicate(final Array array, Predicate<Integer> predicate, int replaceWith) {
        checkArray(array);

        List<Integer> elements = array.getElements();
        List<Integer> newElements = new ArrayList<>();

        for (Integer element : elements) {

            if (predicate.test(element)) {
                newElements.add(replaceWith);
            } else {
                newElements.add(element);
            }
        }

        return new Array(newElements);
    }

    public int getSum(final Array array) {
        checkArray(array);

        List<Integer> elements = array.getElements();

        int sum = 0;

        for (Integer element : elements) {
            sum += element;
        }

        return sum;
    }

    public double getAverage(final Array array) {
        checkArray(array);

        List<Integer> elements = array.getElements();

        double sum = getSum(array);
        return sum / elements.size();
    }

    public int getNumberOfNegatives(final Array array) {
        checkArray(array);

        List<Integer> elements = array.getElements();

        int counter = 0;

        for (Integer element : elements) {
            if (element < 0) {
                counter++;
            }
        }

        return counter;
    }

    public int getNumberOfPositives(final Array array) {
        checkArray(array);

        List<Integer> elements = array.getElements();

        int counter = 0;

        for (Integer element : elements) {
            if (element > 0) {
                counter++;
            }
        }

        return counter;
    }
}
