package ru.ssau.systemprogramming.model.io;

import ru.ssau.systemprogramming.model.Record;

import java.io.IOException;

public interface RecordWriter {
    void write(Record record) throws IOException;
}
