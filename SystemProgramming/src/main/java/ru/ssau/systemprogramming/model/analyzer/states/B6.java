package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class B6 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (SyntaxClass.isDigit(ch)) {
            semantic.addNumberToFirstNumber(ch);
            return this;
        }
        if (ch == ';') {
            return new C1();
        }
        if (ch == ' ') {
            return new B7();
        }
        return new Error(getClass().getSimpleName(), "Char ';' or 'space' expected", reader);
    }
}
