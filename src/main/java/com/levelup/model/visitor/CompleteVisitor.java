package com.levelup.model.visitor;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SMULL on 10/11/2015.
 */
public class CompleteVisitor implements Visitor{

    private Visitor[] parts;
    private List<Object> objects;

    public CompleteVisitor() {
        parts = new Visitor[] {new FloatVisitor(),new IntegerVisitor(),
                                new DateVisitor(),new StringVisitor()};
        objects = new ArrayList<Object>();
    }

    @Override
    public Object visit(String str) {
        return null;
    }

    public List<Object> getObjects() {
        return objects;
    }

    @Override
    public boolean accept(String str) {
        for(int i = 0; i < parts.length; i++) {
            if(parts[i].accept(str)) {
                try {
                    objects.add(parts[i].visit(str));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
