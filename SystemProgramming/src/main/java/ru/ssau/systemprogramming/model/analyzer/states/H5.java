package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class H5 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (ch == ')') {
            return new H6();
        }
        if (ch == ' ') {
            return this;
        }
        return new Error(getClass().getSimpleName(), "Chars ')' or 'space' expected", reader);
    }
}
