package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class H7 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if (ch == '{') {
            return new H8();
        }
        if (ch == ' ') {
            return this;
        }
        return new Error(getClass().getSimpleName(), "Char '{' expected", reader);
    }
}
