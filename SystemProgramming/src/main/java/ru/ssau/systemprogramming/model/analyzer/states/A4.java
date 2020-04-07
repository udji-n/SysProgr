package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;

public class A4 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        switch (ch) {
            case ' ':
                return this;
            case 'i':
                return new A5();
            default:
                return new Error(getClass().getSimpleName(), "Char 'i' expected", reader);
        }
    }
}
