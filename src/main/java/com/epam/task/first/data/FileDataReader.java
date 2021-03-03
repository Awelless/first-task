package com.epam.task.first.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader implements DataReader {

    private final String filename;

    public FileDataReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<String> read() throws DataException {

        try(FileInputStream inputStream = new FileInputStream(filename)) {

            List<String> data = new ArrayList<>();

            StringBuilder currentLine = new StringBuilder();
            int currentByte;

            //While bytes are available
            while((currentByte = inputStream.read()) != -1) {

                char currentChar = (char) currentByte;

                if (currentChar == '\n') {

                    data.add(currentLine.toString());
                    currentLine = new StringBuilder();

                } else {
                    currentLine.append(currentChar);
                }
            }

            if (currentLine.length() > 0) {
                data.add(currentLine.toString());
            }

            return data;

        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

    @Override
    public String toString() {
        return String.format("FileDataReader, filename: \"%s\"", filename);
    }
}
