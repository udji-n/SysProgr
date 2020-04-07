package ru.ssau.systemprogramming.model.analyzer.states;

import ru.ssau.systemprogramming.model.analyzer.Semantic;
import ru.ssau.systemprogramming.model.analyzer.StringReader;

public class Error implements State{

    private final String state;

    private final String message;

    private final int line;

    private final int linePosition;

    private final int absolutePosition;

    public Error(String state, String message, StringReader reader)
    {
        this(state, message, reader.getLine(), reader.getLinePosition(), reader.getAbsolutePosition());
    }

    public Error(String state, String message, int line, int linePosition, int absolutePosition)
    {
        this.state = state;
        this.message = message;
        this.line = line;
        this.linePosition = linePosition;
        this.absolutePosition = absolutePosition;
    }

    public String getState()
    {
        return state;
    }

    public String getMessage()
    {
        return message;
    }

    public int getLine()
    {
        return line;
    }

    public int getLinePosition()
    {
        return linePosition;
    }

    public int getAbsolutePosition()
    {
        return absolutePosition;
    }

    @Override
    public State nextState(StringReader reader, Semantic semantic) {
        return null;
    }
}
