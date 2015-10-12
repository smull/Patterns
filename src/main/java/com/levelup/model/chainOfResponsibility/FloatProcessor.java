package com.levelup.model.chainOfResponsibility;

/**
 * Created by SMULL on 10/11/2015.
 */
public class FloatProcessor extends ChainObject {

    private ChainObject nextInChain;

    @Override
    public void process(String request) {
        if(request.contains(",") || request.contains(".")){
            System.out.println("Float:yes");
            objects.add(Float.valueOf(request));
        } else {
            nextInChain.process(request);
        }
    }

    @Override
    public void setNext(ChainObject c) {
        nextInChain = c;
    }
}
