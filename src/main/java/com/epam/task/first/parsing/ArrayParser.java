package com.epam.task.first.parsing;

import com.epam.task.first.entity.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayParser {

    private static final String NUMBER_REGEX = "\\-?\\d+";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public Array parse(String line) {

        List<Integer> numbers = new ArrayList<>();

        Matcher matcher = NUMBER_PATTERN.matcher(line);

        while(matcher.find()) {

            String matched = matcher.group();
            numbers.add(Integer.valueOf(matched));
        }

        return new Array(numbers);
    }
}
