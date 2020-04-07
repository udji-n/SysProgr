package ru.ssau.systemprogramming.model.analyzer;

import ru.ssau.systemprogramming.model.analyzer.states.State;

public class Result {

    private final State state;
    private final Semantic semantic;

    public Result(State state, Semantic semantic)
    {
        this.state = state;
        this.semantic = semantic;
    }

    public State getState()
    {
        return state;
    }

    public Semantic getSemantic()
    {
        return semantic;
    }
}
