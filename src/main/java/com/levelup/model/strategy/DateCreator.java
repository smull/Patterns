package com.levelup.model.strategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SMULL on 10/12/2015.
 */
public class DateCreator implements Strategy {

    public SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
    private Date date;

    @Override
    public Object process(String str) {
        if(isValidDate(str)){
            System.out.println("Date:yes");
            try {
                date = format.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
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
