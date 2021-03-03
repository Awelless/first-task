package com.epam.task.first.parsing;

import com.epam.task.first.entity.Array;
import org.junit.Assert;
import org.junit.Test;

public class ArrayParserTest {

    private final ArrayParser parser = new ArrayParser();

    @Test
    public void testParseShouldReturnArrayWhenPositivesApplied() {
        String data = "1 2 123";
        Array expected = new Array(1, 2, 123);

        Array result = parser.parse(data);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void testParseShouldReturnArrayWhenNegativesApplied() {
        String data = "-1 -2 -123";
        Array expected = new Array(-1, -2, -123);

        Array result = parser.parse(data);

        Assert.assertEquals(expected, result);
    }
}
