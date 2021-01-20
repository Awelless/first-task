package com.epam.task.first.logic;

import com.epam.task.first.entity.Array;
import com.epam.task.first.util.PredicateInterface;
import org.junit.Assert;
import org.junit.Test;

public class ArrayLogicTest {

    private static final double DELTA = 0.01;

    private final ArrayLogic arrayLogic = new ArrayLogic();

    private final Array arrayOfNegatives = new Array(-7, -8, -5);
    private final Array arrayOfPositives = new Array( 3,  2,  5);
    private final Array mixedArray       = new Array( 0, -1,  3, -2);

    @Test
    public void testFindMinShouldFindMinWhenNegativesApplied() {
        int result = arrayLogic.findMin(arrayOfNegatives);

        Assert.assertEquals(-8, result);
    }

    @Test
    public void testFindMinShouldFindMinWhenPositivesApplied() {
        int result = arrayLogic.findMin(arrayOfPositives);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testFindMinShouldFindMinWhenMixedApplied() {
        int result = arrayLogic.findMin(mixedArray);

        Assert.assertEquals(-2, result);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenNegativesApplied() {
        int result = arrayLogic.findMax(arrayOfNegatives);

        Assert.assertEquals(-5, result);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenPositivesApplied() {
        int result = arrayLogic.findMax(arrayOfPositives);

        Assert.assertEquals(5, result);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenMixedApplied() {
        int result = arrayLogic.findMax(mixedArray);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetSumValueShouldGetSumWhenNegativesApplied() {
        int result = arrayLogic.getSum(arrayOfNegatives);

        Assert.assertEquals(-20, result);
    }

    @Test
    public void testGetSumValueShouldGetSumWhenPositiveApplied() {
        int result = arrayLogic.getSum(arrayOfPositives);

        Assert.assertEquals(10, result);
    }

    @Test
    public void testGetSumValueShouldGetSumWhenMixedApplied() {
        int result = arrayLogic.getSum(mixedArray);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetAverageValueShouldGetAverageWhenNegativesApplied() {
        double result = arrayLogic.getAverage(arrayOfNegatives);

        Assert.assertEquals(-6.667, result, DELTA);
    }

    @Test
    public void testGetAverageValueShouldGetAverageWhenPositivesApplied() {
        double result = arrayLogic.getAverage(arrayOfPositives);

        Assert.assertEquals(3.333, result, DELTA);
    }

    @Test
    public void testGetAverageValueShouldGetAverageWhenMixedApplied() {
        double result = arrayLogic.getAverage(mixedArray);

        Assert.assertEquals(0, result, DELTA);
    }

    @Test
    public void testGetNumberOfNegativesShouldGetNumberOfNegativesWhenNegativesApplied() {
        int result = arrayLogic.getNumberOfNegatives(arrayOfNegatives);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetNumberOfNegativesShouldGetNumberOfNegativesWhenPositivesApplied() {
        int result = arrayLogic.getNumberOfNegatives(arrayOfPositives);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetNumberOfNegativesShouldGetNumberOfNegativesWhenMixedApplied() {
        int result = arrayLogic.getNumberOfNegatives(mixedArray);

        Assert.assertEquals(2, result);
    }

    @Test
    public void testGetNumberOfPositivesShouldGetNumberOfPositivesWhenNegativesApplied() {
        int result = arrayLogic.getNumberOfPositives(arrayOfNegatives);

        Assert.assertEquals(0, result);
    }

    @Test
    public void testGetNumberOfPositivesShouldGetNumberOfPositivesWhenPositivesApplied() {
        int result = arrayLogic.getNumberOfPositives(arrayOfPositives);

        Assert.assertEquals(3, result);
    }

    @Test
    public void testGetNumberOfPositivesShouldGetNumberOfPositivesWhenMixedApplied() {
        int result = arrayLogic.getNumberOfPositives(mixedArray);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testReplaceByPredicateShouldReplaceAllPositives() {
        PredicateInterface predicate = new PredicateInterface() {
            @Override
            public boolean check(Integer value) {
                return value > 0;
            }
        };

        Array array    = new Array( 5, 10, 0, 0,  4, 0);
        Array expected = new Array(-1, -1, 0, 0, -1, 0);

        arrayLogic.replaceByPredicate(array, predicate, -1);

        Assert.assertEquals(expected, array);
    }

    @Test
    public void testReplaceByPredicateShouldReplaceAllZeros() {
        PredicateInterface predicate = new PredicateInterface() {
            @Override
            public boolean check(Integer value) {
                return value == 0;
            }
        };

        Array array    = new Array(5, 10,  0,  0, 4,  0);
        Array expected = new Array(5, 10, -1, -1, 4, -1);

        arrayLogic.replaceByPredicate(array, predicate, -1);

        Assert.assertEquals(expected, array);
    }
}
