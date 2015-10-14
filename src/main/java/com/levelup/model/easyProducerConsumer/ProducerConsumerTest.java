package com.levelup.model.easyProducerConsumer;

import com.levelup.model.strategy.Strategy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by SMULL on 10/14/2015.
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        BlockingQueue<String> orders = new ArrayBlockingQueue<String>(6);

        CashDesk cashDesk1 = new CashDesk(orders,"1");
        CashDesk cashDesk2 = new CashDesk(orders,"2");
        CashDesk cashDesk3 = new CashDesk(orders,"3");
        CashDesk cashDesk4 = new CashDesk(orders,"4");
        CashDesk cashDesk5 = new CashDesk(orders,"5");

        Person person1 = new Person(orders, "James", "Pepsi");
        Person person2 = new Person(orders, "Jim", "Potatoes");
        Person person3 = new Person(orders, "Ben", "Panini");
        Person person4 = new Person(orders, "Mark", "Chicken");
        Person person5 = new Person(orders, "Julia", "Water");

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();


        cashDesk1.start();
        cashDesk2.start();
        cashDesk3.start();
        cashDesk4.start();
        cashDesk5.start();



    }
}
