package ru.ssau.systemprogramming.model.analyzer;

import ru.ssau.systemprogramming.model.analyzer.states.Error;
import ru.ssau.systemprogramming.model.analyzer.states.Final;
import ru.ssau.systemprogramming.model.analyzer.states.Start;
import ru.ssau.systemprogramming.model.analyzer.states.State;

public class Analyzer {

    private StringReader stringReader;

    public Analyzer(StringReader stringReader) {
        this.stringReader = stringReader;
    }

    public Result analyze(){

        Semantic semantic = new Semantic();
        State current = new Start();

        while (!(Final.class.isInstance(current) || Error.class.isInstance(current))) {
            current = current.nextState(stringReader, semantic);
        }

        return new Result(current, semantic);
    }

}
