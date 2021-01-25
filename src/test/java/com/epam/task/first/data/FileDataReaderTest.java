package com.epam.task.first.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FileDataReaderTest {

    private DataReader dataReader;

    @Test
    public void testReadShouldReturnDataLinesWhenIncorrectApplied() throws DataException {

        dataReader = new FileDataReader("./src/test/resources/incorrect_input.txt");
        List<String> expected = Arrays.asList("1 2 3", "4z5 6", "abcde--");

        List<String> read = dataReader.read();

        Assert.assertEquals(expected, read);
    }

    @Test
    public void testReadShouldReturnDataLinesWhenCorrectApplied() throws DataException {

        dataReader = new FileDataReader("./src/test/resources/correct_input.txt");
        List<String> expected = Arrays.asList("1 2 3", "4 5 6", "7 8 9 10");

        List<String> read = dataReader.read();

        Assert.assertEquals(expected, read);
    }
}
