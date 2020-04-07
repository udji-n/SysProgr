package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class F8 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (SyntaxClass.isDigit(ch)) {
            semantic.addNumberToSecondNumber(ch);
            return this;
        }
        if (ch == ' ') {
            return new F9();
        }
        if (ch == ';') {
            return new G1();
        }

        return new Error(getClass().getSimpleName(), "Char ';' or 'space' char expected", reader);
    }
}
