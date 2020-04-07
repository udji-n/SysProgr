package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

import static java.awt.PageAttributes.MediaType.C2;

public class C1 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (ch == ' ') {
            return new C2();
        }
        if (SyntaxClass.isAlphabetic(ch)) {
            semantic.addCharToSecondOperandName(ch);
            return new C4();
        }
        if (SyntaxClass.isDigit(ch)) {
            semantic.setFirstNumberInCondition(true);
            semantic.addNumberToSecondNumber(ch);
            return new C3();
        }

        return new Error(getClass().getSimpleName(), "Digit or char or 'space' char expected", reader);
    }
}
