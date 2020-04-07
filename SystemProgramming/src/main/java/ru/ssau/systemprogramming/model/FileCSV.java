package ru.ssau.systemprogramming.model;

import ru.ssau.systemprogramming.model.io.*;

import java.io.*;
import java.util.*;
/**
 * Класс файла формата CSV
 * @autor Eugene Kornilov
 */
public class FileCSV {

    /** Поле массива записей в файле */
    private List<Record> records;

    /**
     * Пустой конструктор - создание нового объекта
     * @see FileCSV#FileCSV(List<Record>)
     */
    public FileCSV(){}

    /**
     * Конструктор с параметрами - создание нового объекта
     * @param list - список записей типа Record
     * @see FileCSV#FileCSV()
     */
    public FileCSV(List<Record> list) {
        records = list;
    }

    /**
     * Метод добавления новой записи
     * @param record - новая запись для добавления
     */
    public void addNote(Record record) {
        records.add(record);
    }

    /**
     * Метод удаления записи
     * @param index - индекс записи
     */
    public void deleteNote(int index) {
        records.remove(index);
    }

    /**
     * Метод загрузки данных (записей) с *.csv файла
     * @param file - файл для загрузки
     */
    public void readFromFile(File file) throws IOException,InvalidRecordException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            RecordReader reader = new RecordBufferedReader(fileInputStream);
                Record record = reader.read();
                while (record != null) {
                    records.add(record);
                    record = reader.read();
                }
        }
    }

    /**
     * Метод сохранения данных (записей) в *.csv файл
     * @param file - файл для сохранения
     */
    public void writeToFile(File file) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            RecordWriter writer = new RecordPrintWriter(fileOutputStream);
            for (Record rec : records) {
                try {
                    writer.write(rec);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



