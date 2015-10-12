package com.levelup.model.visitor;

/**
 * Created by SMULL on 10/11/2015.
 */
public class IntegerVisitor implements Visitor {

    public static final String NUMBER_PATTERN = "^[0-9]+";

    @Override
    public Object visit(String str) {
        return Integer.valueOf(str);
    }

    @Override
    public boolean accept(String str) {
        if(str.matches(NUMBER_PATTERN)){
           System.out.println("Integer:yes");
           return true;
       }
        System.out.println("Integer:no");
        return false;
    }
}
