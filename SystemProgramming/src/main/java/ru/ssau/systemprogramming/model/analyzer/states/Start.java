package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;

public class Start implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        switch (ch) {
            case ' ':
                return this;
            case 'f':
                return new A1();
            default:
                return new Error(getClass().getSimpleName(), "Char 'f' expected", reader);
        }
    }
}
