package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class C3 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (ch == '>' ||ch == '<') {
            if(ch == '>') semantic.setGreaterCondition(true);
            return new F1();
        }
        if (ch == ' ') {
            return new C5();
        }
        if (SyntaxClass.isDigit(ch)) {
            semantic.addNumberToSecondNumber(ch);
            return this;
        }

        return new Error(getClass().getSimpleName(), "Char'space' or '>' or '<' expected", reader);
    }
}
