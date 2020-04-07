package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class F2 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (ch == '=') {
            semantic.setEqualsign(true);
            return new F4();
        }
        if (ch == ' ') {
            return new F6();
        }
        if (SyntaxClass.isDigit(ch)) {
            semantic.addNumberToSecondNumber(ch);
            return new F8();
        }

        return new Error(getClass().getSimpleName(), "Digit or 'space' char or '=' expected", reader);
    }
}
