package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class F6 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (ch == ' ') {
            return this;
        }
        if (SyntaxClass.isDigit(ch)) {
            semantic.addNumberToSecondNumber(ch);
            return new F8();
        }

        return new Error(getClass().getSimpleName(), "Digit expected", reader);
    }
}
