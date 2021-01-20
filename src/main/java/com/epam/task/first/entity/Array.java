package com.epam.task.first.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
    private final List<Integer> elements;

    public Array(List<Integer> elements) {
        this.elements = elements;
    }

    public Array(Integer...elements) {
        this.elements = new ArrayList<>(Arrays.asList(elements));
    }

    public List<Integer> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (o instanceof Array) {

            List<Integer> otherElements = ((Array) o).getElements();
            return elements.equals(otherElements);

        } else {
            return false;
        }
    }
}
