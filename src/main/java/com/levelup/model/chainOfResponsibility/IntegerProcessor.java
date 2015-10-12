package com.levelup.model.chainOfResponsibility;

/**
 * Created by SMULL on 10/11/2015.
 */
public class IntegerProcessor extends ChainObject{

    private ChainObject nextInChain;
    public static final String NUMBER_PATTERN = "^[0-9]+";


    @Override
    public void process(String request) {
        if(request.matches(NUMBER_PATTERN)){
            System.out.println("Integer:yes");
            objects.add(Integer.valueOf(request));
        } else {
            nextInChain.process(request);
        }
    }

    @Override
    public void setNext(ChainObject c) {
        nextInChain = c;
    }
}
