package com.levelup.model.strategy;

/**
 * Created by SMULL on 10/12/2015.
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Object executeStrategy(String string){
        return strategy.process(string);
    }
}
