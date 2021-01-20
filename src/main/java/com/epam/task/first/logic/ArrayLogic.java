package com.epam.task.first.logic;

import com.epam.task.first.entity.Array;
import com.epam.task.first.util.PredicateInterface;

import java.util.List;

public class ArrayLogic {

    private List<Integer> getElements(Array array) {
        if (array == null) {
            throw new IllegalArgumentException("Array argument mustn't be null");
        }

        List<Integer> elements = array.getElements();

        if (elements.size() == 0) {
            throw new IllegalArgumentException("Array argument mustn't be empty");
        }

        return elements;
    }

    public int findMin(final Array array) {
        List<Integer> elements = getElements(array);

        int min = elements.get(0);

        for (Integer element : elements) {
            if (element < min) {
                min = element;
            }
        }

        return min;
    }

    public int findMax(final Array array) {
        List<Integer> elements = getElements(array);

        int max = elements.get(0);

        for (Integer element : elements) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

    public void replaceByPredicate(Array array, PredicateInterface predicate, int replaceWith) {
        List<Integer> elements = getElements(array);

        for (int i = 0; i < elements.size(); i++) {
            Integer element = elements.get(i);

            if (predicate.check(element)) {
                elements.set(i, replaceWith);
            }
        }
    }

    public int getSum(final Array array) {
        List<Integer> elements = getElements(array);

        int sum = 0;

        for (Integer element : elements) {
            sum += element;
        }

        return sum;
    }

    public double getAverage(final Array array) {
        List<Integer> elements = getElements(array);

        double sum = getSum(array);
        return sum / elements.size();
    }

    public int getNumberOfNegatives(final Array array) {
        List<Integer> elements = getElements(array);

        int counter = 0;

        for (Integer element : elements) {
            if (element < 0) {
                counter++;
            }
        }

        return counter;
    }

    public int getNumberOfPositives(final Array array) {
        List<Integer> elements = getElements(array);

        int counter = 0;

        for (Integer element : elements) {
            if (element > 0) {
                counter++;
            }
        }

        return counter;
    }
}
