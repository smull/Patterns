package com.levelup.model.producerConsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SMULL on 10/14/2015.
 */
public class RestaurantRunner {

    public static void main(String[] args) {
        Restaurant restaurant = createRestaurant();

        Person person;
//        for(int i = 0; i < 9; i++){
//            if(i % 2 == 0)
//                person = new Person("Person" + i,restaurant,createOrderOption1());
//            else if(i % 3 == 0)
//                person = new Person("Person" + i,restaurant,createOrderOption2());
//            else
//                person = new Person("Person" + i,restaurant,createOrderOption3());
//            person.start();
//        }

        Person person1 = new Person("James",restaurant,createOrderOption1());
        Person person2 = new Person("Ben",restaurant,createOrderOption2());
        Person person3 = new Person("Harvey",restaurant,createOrderOption3());
        person1.start();
        person2.start();
        person3.start();




    }

    public static Restaurant createRestaurant(){
        Restaurant restaurant = new Restaurant("KFC",6);
        CashDesk cashDesk1 = new CashDesk(1,130);
        CashDesk cashDesk2 = new CashDesk(2,240);
        CashDesk cashDesk3 = new CashDesk(3,100);
        CashDesk cashDesk4 = new CashDesk(4,120);
        CashDesk cashDesk5 = new CashDesk(5,140);
        CashDesk cashDesk6 = new CashDesk(6,200);

        restaurant.addCashDesk(cashDesk1);
        restaurant.addCashDesk(cashDesk2);
        restaurant.addCashDesk(cashDesk3);
        restaurant.addCashDesk(cashDesk4);
        restaurant.addCashDesk(cashDesk5);
        restaurant.addCashDesk(cashDesk6);

        return restaurant;
    }

    public static List<String> createOrderOption1(){
        List<String> orders = new LinkedList<String>();
        orders.add("Potatoes");
        orders.add("Pepsi");
        orders.add("Sandwich");
        return orders;
    }

    public static List<String> createOrderOption2(){
        List<String> orders = new LinkedList<String>();
        orders.add("Chicken");
        return orders;
    }

    public static List<String> createOrderOption3(){
        List<String> orders = new LinkedList<String>();
        orders.add("Pepsi");
        orders.add("Panini");
        return orders;
    }
}
