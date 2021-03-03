package com.epam.task.first;

import com.epam.task.first.data.DataException;
import com.epam.task.first.data.DataReader;
import com.epam.task.first.entity.Array;
import com.epam.task.first.parsing.ArrayParser;
import com.epam.task.first.parsing.ArrayValidator;
import com.epam.task.first.parsing.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ArrayCreator {

    private static final Logger LOGGER = LogManager.getLogger();

    private final DataReader dataReader;
    private final ArrayValidator validator;
    private final ArrayParser parser;

    public ArrayCreator(final DataReader dataReader, final ArrayValidator validator, final ArrayParser parser) {
        this.dataReader = dataReader;
        this.validator = validator;
        this.parser = parser;
    }

    public List<Array> create() throws DataException {

        List<String> data = dataReader.read();

        List<Array> arrays = new ArrayList<>();

        for (int i = 0; i < data.size(); ++i) {

            String line = data.get(i);

            try {
                validator.test(line);

                Array array = parser.parse(line);
                arrays.add(array);

            } catch (ValidationException e) {

                LOGGER.warn("Invalid input in: {}. Line: {}, column: {}.", dataReader.toString(), i + 1, e.getColumn() + 1);
            }
        }

        return arrays;
    }
}
