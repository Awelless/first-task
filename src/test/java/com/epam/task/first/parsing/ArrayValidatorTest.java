package com.epam.task.first.parsing;

import org.junit.Assert;
import org.junit.Test;

public class ArrayValidatorTest {

    private final ArrayValidator validator = new ArrayValidator();

    @Test
    public void testShouldntThrowExceptionWhenCorrectApplied() throws ValidationException {
        String data = "1 2 3 -5 123";

        validator.test(data);
    }

    @Test
    public void testShouldThrowExceptionWhenIncorrectApplied() {
        String data = "1 -2-3";

        try {
            validator.test(data);
        } catch (ValidationException e) {
            Assert.assertEquals(4, e.getColumn());
        }
    }

    @Test
    public void testShouldThrowExceptionWhenIncorrectWithLettersApplied() {
        String data = "1 2 3 z";

        try {
            validator.test(data);
        } catch (ValidationException e) {
            Assert.assertEquals(6, e.getColumn());
        }
    }

    @Test
    public void testShouldThrowExceptionWhenMinusesApplied() {
        String data = "1 -2 --3";

        try {
            validator.test(data);
        } catch (ValidationException e) {
            Assert.assertEquals(5, e.getColumn());
        }
    }

}
