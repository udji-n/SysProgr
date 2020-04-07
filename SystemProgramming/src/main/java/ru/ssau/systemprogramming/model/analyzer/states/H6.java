package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class H6 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if(!semantic.compareMainOperandWithThird()){
            return new Error(getClass().getSimpleName(),
                    String.format("Don't match operand '%s' and '%s'!", semantic.getOperandName(), semantic.getThirdOperandName()),
                    reader);
        }

        if (ch == '{') {
            return new H8();
        }
        if (ch == ' ') {
            return new H7();
        }
        return new Error(getClass().getSimpleName(), "Chars '{' or 'space' expected", reader);
    }
}
