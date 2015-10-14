package com.levelup.model.easyProducerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by SMULL on 10/14/2015.
 */
public class Person extends Thread {

    private BlockingQueue<String> orders;
    private String nameOfPerson;
    private String order;

    public Person(BlockingQueue<String> orders, String nameOfPerson, String order){
        this.nameOfPerson = nameOfPerson;
        this.order = order;
        this.orders = orders;
    }

    public synchronized String getOrder() {
        return order;
    }

    public synchronized String getNameOfPerson() {
        return nameOfPerson;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            try {
                orders.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
