package com.levelup.model.visitor;

import java.text.ParseException;

/**
 * Created by SMULL on 10/11/2015.
 */
public interface Visitor {

    public boolean accept(String str);
    public Object visit(String str) throws ParseException;

}
