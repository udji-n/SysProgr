package ru.ssau.systemprogramming.model.io;

import ru.ssau.systemprogramming.model.Record;

import java.io.IOException;

public interface RecordReader {
    Record read() throws IOException, InvalidRecordException;
}
