package ru.ssau.systemprogramming.model.io;

import javafx.scene.control.TextArea;

import java.util.Date;

public class TextAreaLogger implements Logger {

    private TextArea textArea;

    public TextAreaLogger(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void log(String message) {
        textArea.appendText(String.format("%s \t %s \n", new Date().toString(), message));
    }
}
