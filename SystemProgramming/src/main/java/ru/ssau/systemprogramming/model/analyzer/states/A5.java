package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;

public class A5 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        switch (ch) {
            case 'n':
                return new A6();
            default:
                return new Error(getClass().getSimpleName(), "Char 'n' expected", reader);
        }
    }
}
