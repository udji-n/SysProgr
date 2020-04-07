package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class H8 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (SyntaxClass.isAlphabetic(ch) || SyntaxClass.isDigit(ch) || ch == ' ' || ch == '\n') {
            return this;
        }
        if (ch == '}') {
            return new Final();
        }
        return new Error(getClass().getSimpleName(), "Char '{' expected", reader);
    }
}
