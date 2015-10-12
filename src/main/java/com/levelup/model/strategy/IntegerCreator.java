package com.levelup.model.strategy;

/**
 * Created by SMULL on 10/12/2015.
 */
public class IntegerCreator implements Strategy {

    public static final String NUMBER_PATTERN = "^[0-9]+";


    @Override
    public Object process(String str) {
        if(str.matches(NUMBER_PATTERN)){
            System.out.println("Integer:yes");
            return Integer.valueOf(str);
        } else {
            System.out.println("Integer:no");
            return new Object();
        }
    }
}
