package com.levelup.model.strategy;

/**
 * Created by SMULL on 10/12/2015.
 */
public class StringCreator implements Strategy {

    public static final String STRING_PATTERN = "^[a-zA-Z]+$";

    @Override
    public Object process(String str) {
        String objectString = null;
        if(str.matches(STRING_PATTERN)) {
            objectString = new String(str);
            System.out.println("Str:yes");
        }
        return objectString;
    }
}
