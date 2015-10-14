package com.levelup.model.producerConsumer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * Created by SMULL on 10/14/2015.
 */
public class Restaurant {

    private String name;
    private int quantityOfCashDesk;
    private BlockingQueue<CashDesk> cashDesks;

    public Restaurant(String name,int quantityOfCashDesk) {
        this.name = name;
        this.quantityOfCashDesk = quantityOfCashDesk;
        cashDesks = new ArrayBlockingQueue<CashDesk>(quantityOfCashDesk);
    }

    public void addCashDesk(CashDesk cashDesk){
        try {
            cashDesks.put(cashDesk);
            cashDesk.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }

    public BlockingQueue<CashDesk> getCashDesks() {
        return cashDesks;
    }
}
