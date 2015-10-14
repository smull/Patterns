package com.levelup.model.easyProducerConsumer1;

/**
 * Created by SMULL on 10/14/2015.
 */
public class Cash extends Thread {

    private Restaurant restaurant;
    private Person person;

    public Cash(Restaurant restaurant, Person person){
        this.person = person;
        this.restaurant = restaurant;
        start();
    }

    @Override
    public void run() {
        while (true){
            if(restaurant.getOrder() == null){
                restaurant.setOrder(new Order());
                System.out.println("Order");
                synchronized (person){
                    person.notify();
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }
    }
}
