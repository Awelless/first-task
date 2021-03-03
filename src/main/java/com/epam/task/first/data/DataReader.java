package com.epam.task.first.data;

import java.util.List;

public interface DataReader {

    List<String> read() throws DataException;
}
