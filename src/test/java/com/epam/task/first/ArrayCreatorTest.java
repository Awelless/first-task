package com.epam.task.first;

import com.epam.task.first.data.DataException;
import com.epam.task.first.data.DataReader;
import com.epam.task.first.data.FileDataReader;
import com.epam.task.first.entity.Array;
import com.epam.task.first.parsing.ArrayParser;
import com.epam.task.first.parsing.ArrayValidator;
import com.epam.task.first.parsing.ValidationException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ArrayCreatorTest {

    private ArrayCreator creator;

    @Test
    public void testCreateShouldReturnListOfAllArrays() throws DataException, ValidationException {
        //given
        final List<Array> arrays = Arrays.asList(new Array(1, 2, 3),
                                                 new Array(4, 5, 6),
                                                 new Array(7, 8, 9));

        initTest1(arrays);

        //when
        List<Array> result = creator.create();

        //then
        Assert.assertEquals(arrays, result);
    }

    private void initTest1(List<Array> arrays) throws DataException, ValidationException {
        final List<String> strings = Arrays.asList("1 2 3", "4 5 6", "7 8 9");

        DataReader dataReader = Mockito.mock(FileDataReader.class);
        when(dataReader.read()).thenReturn(strings);

        ArrayValidator validator = Mockito.mock(ArrayValidator.class);
        doNothing().when(validator).test(anyString());

        ArrayParser parser = Mockito.mock(ArrayParser.class);
        when(parser.parse("1 2 3")).thenReturn(arrays.get(0));
        when(parser.parse("4 5 6")).thenReturn(arrays.get(1));
        when(parser.parse("7 8 9")).thenReturn(arrays.get(2));

        creator = new ArrayCreator(dataReader, validator, parser);
    }

    @Test
    public void testCreateShouldReturnListOfArraysExcludingIncorrect() throws ValidationException, DataException {
        //given
        final List<Array> arrays = Collections.singletonList(new Array(1, 2, 3));

        initTest2(arrays);

        //when
        List<Array> result = creator.create();

        //then
        Assert.assertEquals(arrays, result);
    }

    private void initTest2(List<Array> arrays) throws DataException, ValidationException {
        final List<String> strings = Arrays.asList("1 2 3", "4z5 6", "7 8--9");

        DataReader dataReader = Mockito.mock(FileDataReader.class);
        when(dataReader.read()).thenReturn(strings);
        when(dataReader.toString()).thenReturn("FileDataReader, filename: \"input.txt\"");

        ArrayValidator validator = Mockito.mock(ArrayValidator.class);
        doNothing().when(validator).test("1 2 3");
        doThrow(new ValidationException(1, "Applied row is invalid"))
                .when(validator).test("4z5 6");
        doThrow(new ValidationException(3, "Applied row is invalid"))
                .when(validator).test("7 8--9");

        ArrayParser parser = Mockito.mock(ArrayParser.class);
        when(parser.parse("1 2 3")).thenReturn(arrays.get(0));

        creator = new ArrayCreator(dataReader, validator, parser);
    }
}
