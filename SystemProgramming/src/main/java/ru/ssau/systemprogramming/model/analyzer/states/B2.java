package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class B2 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if (SyntaxClass.isAlphabeticOrDigit(ch)) {
            semantic.addCharToOperandName(ch);
            return this;
        }
        if(ch == ' '){
            return new B3();
        }
        if(ch == '='){
            return new B4();
        }

        return new Error(getClass().getSimpleName(), "Char '=' or 'space' expected", reader);
    }
}
