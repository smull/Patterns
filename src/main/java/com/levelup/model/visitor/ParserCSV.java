package com.levelup.model.visitor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by SMULL on 10/11/2015.
 */
public class ParserCSV {

    public CompleteVisitor completeVisitor;

    public static void main(String[] args) {
        ParserCSV obj = new ParserCSV();
        obj.run();
    }


    public void run() {
        String csvFile = "D:/CSV/file.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        completeVisitor = new CompleteVisitor();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] objects = line.split(cvsSplitBy);
                for (String s : objects) {
                    completeVisitor.accept(s);
                    System.out.println("=========================");
                }
//                System.out.println(objects[0] + "  " + objects[1] + "  "
//                        + objects[2] + "  " + objects[3]);
//
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

        for (Object o : completeVisitor.getObjects()) {
            System.out.println(o.getClass() + " = " + o);
        }

        System.out.println("Done");
    }
}
