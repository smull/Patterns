package com.levelup.model.visitor;

/**
 * Created by SMULL on 10/11/2015.
 */
public class FloatVisitor implements Visitor {

    @Override
    public Object visit(String str) {
        return Float.valueOf(str);
    }

    @Override
    public boolean accept(String str) {
        if(str.contains(",") || str.contains(".")){
            System.out.println("Float:yes");
            return true;
        }
        System.out.println("Float:no");
        return false;
    }
}
