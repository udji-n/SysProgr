package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class H1 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (SyntaxClass.isAlphabetic(ch)) {
            semantic.addCharToThirdOperandName(ch);
            return this;
        }
        if (ch == '-') {
            return new H2();
        }
        if (ch == '+') {
            return new H3();
        }
        return new Error(getClass().getSimpleName(), "Char or '+' or '-' expected", reader);
    }
}
