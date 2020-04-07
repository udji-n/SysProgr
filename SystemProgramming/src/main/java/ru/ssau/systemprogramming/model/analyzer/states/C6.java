package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class C6 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();
        if (ch == '>' ||ch == '<') {
            if(ch == '>') semantic.setGreaterCondition(true);
            return new F2();
        }
        if (ch == ' ') {
            return this;
        }

        return new Error(getClass().getSimpleName(), "Chars '>' or '<' expected", reader);
    }
}
