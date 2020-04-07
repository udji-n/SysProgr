package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;

public class A3 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        switch (ch) {
            case ' ':
                return this;
            case '(':
                return new A4();
            default:
                return new Error(getClass().getSimpleName(), "Char '(' expected", reader);
        }
    }
}
