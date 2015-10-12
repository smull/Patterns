package com.levelup.model.chainOfResponsibility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SMULL on 10/11/2015.
 */
public class DateProcessor extends ChainObject {

    private ChainObject nextInChain;
    private SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
    private Date date;

    @Override
    public void process(String request) {
        if(isValidDate(request)){
            System.out.println("Date:yes");
            try {
                date = format.parse(request);
                objects.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else {
            nextInChain.process(request);
        }

    }

    @Override
    public void setNext(ChainObject c) {
        nextInChain = c;
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
