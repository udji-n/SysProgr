package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class B4 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if (SyntaxClass.isDigit(ch)) {
            semantic.addNumberToFirstNumber(ch);
            return new B6();
        }
        if (ch == ' ') {
            return new B5();
        }
        return new Error(getClass().getSimpleName(), "Digit or char 'space' expected", reader);

    }
}
