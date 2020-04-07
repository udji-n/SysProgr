package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class H3 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if (ch == '+') {
            semantic.setIncrementrCondition(true);
            return new H4();
        }
        return new Error(getClass().getSimpleName(), "Char '+' expected", reader);
    }
}
