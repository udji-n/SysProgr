package ru.ssau.systemprogramming.model.analyzer;

public class StringReader {

    private String text;

    private int index = 0;

    private int line = 1;

    private int linePosition = 0;

    private int absolutePosition = 0;

    public StringReader(String text) {
        this.text = text;
    }

    public char read() {
        if (index < text.length()) {
            char ch = text.charAt(index++);

            linePosition++;
            absolutePosition++;
            if (ch == '\n') {
                line++;
                linePosition = 1;
            }

            return ch;
        }
        return (char) -1;
    }


    public int getLine() {
        return line;
    }

    public int getLinePosition() {
        return linePosition;
    }

    public int getAbsolutePosition() {
        return absolutePosition;
    }
}
