package ru.ssau.systemprogramming.model.io;

import ru.ssau.systemprogramming.model.Record;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;


public class FileInformationReader {

    private File file;

    public FileInformationReader(File file) {
        this.file = file;
    }

    public Record getFileInformation() throws IOException {
        Path path = file.toPath();
        BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
        String fileName = file.getName();
        long size = attributes.size();
        String date = attributes.creationTime().toString();
        return new Record(fileName, size, date);
    }
}
