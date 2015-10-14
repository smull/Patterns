package com.levelup.model.easyProducerConsumer1;

/**
 * Created by SMULL on 10/14/2015.
 */
public class Restaurant {

    private static Object monitor = new Object();
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Person person = new Person(restaurant);
        Cash cash = new Cash(restaurant,person);


    }
}
