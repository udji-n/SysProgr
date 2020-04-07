package ru.ssau.systemprogramming.model.analyzer;

import java.util.Arrays;

public class SyntaxClass {
    public static final Character[] ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private SyntaxClass()
    {
    }

    public static boolean isAlphabetic(char ch)
    {
        return Arrays.stream(ALPHABET).anyMatch(each -> ch == each);
    }

    public static boolean isAlphabeticOrDigit(char ch)
    {
        return isAlphabetic(ch) || Character.isDigit(ch);
    }

    public static boolean isDigit(char ch)
    {
        return Character.isDigit(ch);
    }

    public static int charDigitToInt(char ch)
    {
        return ch - '0';
    }
}
