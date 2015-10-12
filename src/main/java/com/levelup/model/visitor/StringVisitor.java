package com.levelup.model.visitor;

/**
 * Created by SMULL on 10/11/2015.
 */
public class StringVisitor implements Visitor {

    public static final String STRING_PATTERN = "^[a-zA-Z]+$";


    @Override
    public Object visit(String str) {
        return new String(str);
    }

    @Override
    public boolean accept(String str) {
//        if(CompleteVisitor.flag == false) {
//            System.out.println("String:yes");
//            return true;
//        } else {
//            System.out.println("String:no");
//            return false;
//        }
        if(str.matches(STRING_PATTERN)){
            System.out.println("String:yes");
            return true;
        } else
            return false;
    }
}
