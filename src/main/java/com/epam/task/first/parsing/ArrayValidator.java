package com.epam.task.first.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayValidator {

    private static final String INVALID_REGEX = "[^\\d\\- ]";
    private static final String NUMBER_REGEX  = "\\-?\\d+";

    private static final Pattern INVALID_PATTERN = Pattern.compile(INVALID_REGEX);
    private static final Pattern NUMBER_PATTERN  = Pattern.compile(NUMBER_REGEX);


    public void test(String line) throws ValidationException {

        Matcher invalidMatcher = INVALID_PATTERN.matcher(line);

        if(invalidMatcher.find()) {

            int column = invalidMatcher.start();

            throw new ValidationException(column, "Applied row is invalid");
        }

        Matcher numberMatcher = NUMBER_PATTERN.matcher(line);

        int previousMatchEnd = -2;

        while (numberMatcher.find()) {

            int start = numberMatcher.start();
            int expectedStart = previousMatchEnd + 2;

            if (expectedStart != start) {

                int column = Math.min(expectedStart, start);

                throw new ValidationException(column, "Applied row is invalid");
            }

            previousMatchEnd = numberMatcher.end() - 1;
        }
    }
}
