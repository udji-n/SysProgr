package ru.ssau.systemprogramming.model.io;

import ru.ssau.systemprogramming.model.Record;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecordBufferedReader implements RecordReader{

    private BufferedReader bufferedReader;

    private String line;

    public RecordBufferedReader(FileInputStream fileInputStream){
        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
    }

    @Override
    public Record read() throws IOException, InvalidRecordException {
        line = bufferedReader.readLine();
        if(line == null){
            return null;
        }else {
            String[] attributes = line.split(";");
            if (attributes.length != 3) throw new InvalidRecordException("Invalid format of record, you should use three fields!");

            for (int i = 0; i < attributes.length; i++) {
                attributes[i] = attributes[i].replace('"', ' ').trim();
            }

            String name = attributes[0];
            String date = attributes[2];
            long size = 0;

            try {
                size = Long.parseLong(attributes[1]);
            }catch (Exception e){
                throw new InvalidRecordException("Invalid information about size of file!");
            }

            return new Record(name, size, date);
        }
    }
}
