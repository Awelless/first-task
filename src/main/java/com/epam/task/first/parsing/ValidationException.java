package com.epam.task.first.parsing;

public class ValidationException extends Exception {

    private final int column;

    public ValidationException(int column, String message) {
        super(message);
        this.column = column;
    }

    public int getColumn() {
        return column;
    }
}
