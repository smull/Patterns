package com.levelup.model.chainOfResponsibility;

/**
 * Created by SMULL on 10/11/2015.
 */
public class StringProcessor extends ChainObject {

    public static final String STRING_PATTERN = "^[a-zA-Z]+$";
    private ChainObject nextInChain;

    @Override
    public void process(String request) {
        if(request.matches(STRING_PATTERN)){
            objects.add(new String(request));
            System.out.println("Str:yes");
        } else {
            nextInChain.process(request);
        }
    }

    @Override
    public void setNext(ChainObject c) {
        nextInChain = c;
    }
}
