package com.levelup.model.strategy;

/**
 * Created by SMULL on 10/12/2015.
 */
public class FloatCreator implements Strategy {

    @Override
    public Object process(String str) {
        if(str.contains(",") || str.contains(".")) {
            System.out.println("Float:yes");
            return Float.valueOf(str);
        }
        return new Object();
    }
}
