package com.epam.task.first.logic;

import com.epam.task.first.entity.Array;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

public class ArrayLogicTest {

    private static final double DELTA = 0.01;

    private final ArrayLogic arrayLogic = new ArrayLogic();

    private static final Array NEGATIVE_ARRAY = new Array(-7, -8, -5);
    private static final Array POSITIVE_ARRAY = new Array( 3,  2,  5);
    private static final Array MIXED_ARRAY    = new Array( 0, -1,  3, -2);

    @Test
    public void testFindMinShouldFindMinWhenNegativeApplied() {
        int result = arrayLogic.findMin(NEGATIVE_ARRAY);

        Assert.assertEquals(-8, result);
    }

    @Test
    public void testFindMinShouldFindMinWhenPositiveApplied() {
        int result = arrayLogic.findMin(POSITIVE_ARRAY);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testFindMinShouldFindMinWhenMixedApplied() {
        int result = arrayLogic.findMin(MIXED_ARRAY);

        Assert.assertEquals(-2, result);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenNegativeApplied() {
        int result = arrayLogic.findMax(NEGATIVE_ARRAY);

        Assert.assertEquals(-5, result);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenPositiveApplied() {
        int result = arrayLogic.findMax(POSITIVE_ARRAY);

        Assert.assertEquals(5, result);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenMixedApplied() {
        int result = arrayLogic.findMax(MIXED_ARRAY);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetSumValueShouldGetSumWhenNegativeApplied() {
        int result = arrayLogic.getSum(NEGATIVE_ARRAY);

        Assert.assertEquals(-20, result);
    }

    @Test
    public void testGetSumValueShouldGetSumWhenPositiveApplied() {
        int result = arrayLogic.getSum(POSITIVE_ARRAY);

        Assert.assertEquals(10, result);
    }

    @Test
    public void testGetSumValueShouldGetSumWhenMixedApplied() {
        int result = arrayLogic.getSum(MIXED_ARRAY);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetAverageValueShouldGetAverageWhenNegativeApplied() {
        double result = arrayLogic.getAverage(NEGATIVE_ARRAY);

        Assert.assertEquals(-6.667, result, DELTA);
    }

    @Test
    public void testGetAverageValueShouldGetAverageWhenPositiveApplied() {
        double result = arrayLogic.getAverage(POSITIVE_ARRAY);

        Assert.assertEquals(3.333, result, DELTA);
    }

    @Test
    public void testGetAverageValueShouldGetAverageWhenMixedApplied() {
        double result = arrayLogic.getAverage(MIXED_ARRAY);

        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void testGetNumberOfNegativesShouldGetNumberOfNegativesWhenNegativeApplied() {
        int result = arrayLogic.getNumberOfNegatives(NEGATIVE_ARRAY);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetNumberOfNegativesShouldGetNumberOfNegativesWhenPositiveApplied() {
        int result = arrayLogic.getNumberOfNegatives(POSITIVE_ARRAY);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetNumberOfNegativesShouldGetNumberOfNegativesWhenMixedApplied() {
        int result = arrayLogic.getNumberOfNegatives(MIXED_ARRAY);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetNumberOfPositivesShouldGetNumberOfPositivesWhenNegativeApplied() {
        int result = arrayLogic.getNumberOfPositives(NEGATIVE_ARRAY);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetNumberOfPositivesShouldGetNumberOfPositivesWhenPositiveApplied() {
        int result = arrayLogic.getNumberOfPositives(POSITIVE_ARRAY);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetNumberOfPositivesShouldGetNumberOfPositivesWhenMixedApplied() {
        int result = arrayLogic.getNumberOfPositives(MIXED_ARRAY);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testReplaceByPredicateShouldReplaceAllPositives() {
        Predicate<Integer> predicate = new Predicate<>() {
            @Override
            public boolean test(Integer value) {
                return value > 0;
            }
        };

        Array array    = new Array( 5, 10, 0, 0,  4, 0);
        Array expected = new Array(-1, -1, 0, 0, -1, 0);

        array = arrayLogic.replaceByPredicate(array, predicate, -1);

        Assert.assertEquals(expected, array);
    }

    @Test
    public void testReplaceByPredicateShouldReplaceAllZeros() {
        Predicate<Integer> predicate = new Predicate<>() {
            @Override
            public boolean test(Integer value) {
                return value == 0;
            }
        };

        Array array    = new Array(5, 10,  0,  0, 4,  0);
        Array expected = new Array(5, 10, -1, -1, 4, -1);

        array = arrayLogic.replaceByPredicate(array, predicate, -1);

        Assert.assertEquals(expected, array);
    }
}
