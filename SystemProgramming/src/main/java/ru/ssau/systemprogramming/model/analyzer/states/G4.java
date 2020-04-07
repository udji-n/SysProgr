package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;
import ru.ssau.systemprogramming.model.analyzer.SyntaxClass;

public class G4 implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        char ch = reader.read();

        if (SyntaxClass.isAlphabetic(ch)) {
            semantic.setIncrementrCondition(false);
            semantic.addCharToThirdOperandName(ch);
            return new G6();
        }

        return new Error(getClass().getSimpleName(), "Char expected", reader);
    }
}
