package com.levelup.model.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SMULL on 10/11/2015.
 */
public abstract class ChainObject {

    public static List<Object> objects = new ArrayList<Object>();;


    public abstract void setNext(ChainObject c);
    public abstract void process(String request);
}
