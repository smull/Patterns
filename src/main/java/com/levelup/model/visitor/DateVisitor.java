package com.levelup.model.visitor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SMULL on 10/11/2015.
 */
public class DateVisitor implements Visitor {

    public SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");

    @Override
    public Object visit(String str) throws ParseException {
        Date date = format.parse(str);
        return date;
    }

    @Override
    public boolean accept(String str) {
        if(isValidDate(str)){
            System.out.println("Date:yes");
            return true;
        }
        System.out.println("Date:no");
        return false;

    }



    private boolean isValidDate(String input) {
        try {
            format.parse(input);
            return true;
        }
        catch(ParseException e){
            return false;
        }
    }
}
