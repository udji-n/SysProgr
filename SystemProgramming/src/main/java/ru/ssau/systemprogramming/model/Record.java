package ru.ssau.systemprogramming.model;

import javax.persistence.*;

/**
 * Класс записи для FileCSV
 * @see FileCSV
 * @autor Eugene Kornilov
 */

@Entity
@Table(name = "records")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /** Поле имени файла */
    @Column(name = "fileName")
    private String fileName;

    /** Поле размера (в байтах) файла*/
    @Column(name = "fileSize")
    private long fileSize;

    /** Поле даты создания файла */
    @Column(name = "date")
    private String date;

    /**
     * Пустой конструктор - создание нового объекта
     * @see Record#Record(String,long,String)
     */
    public Record(){}

    /**
     * Конструктор с параметрами - создание нового объекта
     * @param fileName - имя файла
     * @param fileSize - размер файла (в байтах)
     * @param date - дата создания файла
     * @see Record#Record()
     */
    public Record(String fileName, long fileSize, String date) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.date = date;
    }

    /**
     * Метод получения имени файла
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Метод установки имени файла
     * @param fileName - новое значение имени
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Метод получения размера файла (в байтах)
     */
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Метод установки размера файла
     * @param fileSize - новое значение размера
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * Метод получения даты создания файла
     */
    public String getDate() {
        return date;
    }

    /**
     * Метод установки даты создания файла
     * @param date - новое значение даты создания
     */
    public void setDate(String date) {
        this.date = date;
    }
}
