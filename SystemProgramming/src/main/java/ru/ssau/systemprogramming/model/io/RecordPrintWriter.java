package ru.ssau.systemprogramming.model.io;

import ru.ssau.systemprogramming.model.Record;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class RecordPrintWriter implements RecordWriter{

    private PrintWriter printWriter;

    public RecordPrintWriter(FileOutputStream fileOutputStream){
        printWriter = new PrintWriter(new OutputStreamWriter(fileOutputStream));
    }

    @Override
    public void write(Record record) throws IOException {
        printWriter.write("\"" + record.getFileName() + "\";\"" + record.getFileSize() + "\";\"" + record.getDate() + "\"\n");
        printWriter.flush();
    }

}
