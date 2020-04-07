package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;

public class Final implements State {
    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        return null;
    }
}
