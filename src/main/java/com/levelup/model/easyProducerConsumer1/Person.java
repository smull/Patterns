package com.levelup.model.easyProducerConsumer1;

/**
 * Created by SMULL on 10/14/2015.
 */
public class Person extends Thread {

    private Restaurant restaurant;

    public Person(Restaurant restaurant){
        this.restaurant = restaurant;
        start();
    }

    @Override
    public void run() {
        while (true){
            while (restaurant.getOrder() == null){
                synchronized (this){
                    try {
                        wait();
                    }catch (InterruptedException ex){
                        throw new RuntimeException();
                    }
                }
                System.out.println("Person got " + restaurant.getOrder());
                restaurant.setOrder(null);
            }
        }
    }
}
