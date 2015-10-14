package com.levelup.model.easyProducerConsumer1;

/**
 * Created by SMULL on 10/14/2015.
 */
public class Order {

    private static int i = 0;
    private int count = i++;

    public Order() {
        if(count == 10){
            System.out.println("Closing");
            System.exit(0);
        }
    }

    @Override
    public String toString() {
        return "Order " + count;
    }
}
