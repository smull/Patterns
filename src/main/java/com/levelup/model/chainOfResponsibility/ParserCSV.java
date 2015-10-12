package com.levelup.model.chainOfResponsibility;

import com.levelup.model.visitor.CompleteVisitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by SMULL on 10/11/2015.
 */
public class ParserCSV {

    public ChainObject chain;

    public static void main(String[] args) {

        ParserCSV obj = new ParserCSV();
        obj.run();

    }


    public void run() {
        String csvFile = "D:/CSV/file.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        chain = setUpChain();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] objectsType = line.split(cvsSplitBy);
                for (String s : objectsType) {
                    chain.process(s);
                    System.out.println("=========================");
                }
//                System.out.println(objectsType[0] + "  " + objectsType[1] + "  "
//                        + objectsType[2] + "  " + objectsType[3]);

//                break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Object o : chain.objects) {
            System.out.println(o.getClass() + " = " + o);
        }
        System.out.println("Done");
    }

    public static ChainObject setUpChain() {
        ChainObject c1 = new StringProcessor();
        ChainObject c2 = new DateProcessor();
        ChainObject c3 = new FloatProcessor();
        ChainObject c4 = new IntegerProcessor();

        c1.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);

        return c1;
    }
}
