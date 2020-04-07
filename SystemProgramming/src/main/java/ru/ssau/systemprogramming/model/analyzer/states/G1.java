package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class G1 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if(!semantic.compareMainOperandWithSecond()){
            return new Error(getClass().getSimpleName(),
                    String.format("Don't match operand '%s' and '%s'!", semantic.getOperandName(), semantic.getSecondOperandName()),
                    reader);
        }

        if (ch == ' ') {
            return this;
        }
        if (ch == '-') {
            return new G2();
        }
        if (ch == '+') {
            return new G3();
        }
        if (SyntaxClass.isAlphabetic(ch)) {
            semantic.addCharToThirdOperandName(ch);
            return new H1();
        }

        return new Error(getClass().getSimpleName(), "Char or '+' or '-' expected", reader);
    }
}
