package com.levelup.model.producerConsumer;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SMULL on 10/14/2015.
 */
public class Person extends Thread {

    private String namePerson;
    private CashDesk cashDesk;
    private Restaurant restaurant;
    private List<String> orders;
    private boolean isBeingServed;
    private boolean isServed;
    private static ReentrantLock lock = new ReentrantLock();


    public Person() {
    }

    public Person(String name,Restaurant restaurant,
                  List<String> orders) {
        this.namePerson = name;
        this.restaurant = restaurant;
        this.orders = orders;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public synchronized List<String> getOrders(){
        return Collections.unmodifiableList(orders);
    }


    private CashDesk chooseCashDesk(){
        CashDesk result = restaurant.getCashDesks().peek();
        //result can be null
        for (CashDesk cashDesk : restaurant.getCashDesks()) {
            if(cashDesk.getPeople().size() < result.getPeople().size())
                result = cashDesk;
        }
        return result;
    }

    public boolean startServe(CashDesk cashDesk) {
        lock.lock();
        try {
            if (cashDesk != this.cashDesk) {
                return false;
            }
            if (isServed) {
                throw new IllegalStateException("It`s not served");
            }
            isBeingServed = true;
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void finishServe(CashDesk cashDesk){
        lock.lock();
        try{
            if(!isBeingServed){
                throw  new IllegalStateException("It`s not being served");
            }
            isBeingServed = false;
            isServed = true;
        }finally {
            lock.unlock();
        }
    }

    private boolean tryEnterQueue(CashDesk cashDesk){
        try {
            cashDesk.addPerson(this);
            this.cashDesk = cashDesk;
            return true;
        }catch (IllegalStateException ex){
            System.out.println("Person " + getName() +
                        "cannot enqueue to cashDesk#" + cashDesk.getNumberIDCash());
            return false;
        }
    }

    private void switchToBetterCashDeskIfPossible(){
        lock.lock();
        boolean skipSwitch = isBeingServed;
        lock.unlock();

        if(skipSwitch)
            return;
        CashDesk result = chooseCashDesk();
        if(result == cashDesk)
            return;
        cashDesk.removePerson(this);

        if(tryEnterQueue(cashDesk)){
            System.out.println("Person " + getName() + " moved to cashDesk#" +
                               cashDesk.getNumberIDCash());
        }
    }

    @Override
    public void run() {
        System.out.println("Person " + namePerson + " comes to restaurant "
                            + restaurant.getName());

        if(!tryEnterQueue(chooseCashDesk())){
            System.out.println("Person " + getNamePerson() +
                                "couldn`t enqueue to the cashDesk#" + cashDesk.getNumberIDCash());
            return;
        }
        System.out.println("Person " + getNamePerson() + " chosen the cashDesk#" +
                                cashDesk.getNumberIDCash());

        //we are in the status of not served
//        while(true){
//            lock.lock();
//            boolean finishLoop = isBeingServed;
//            lock.unlock();
//            if(finishLoop)
//                return;
//            try {
//                Thread.sleep(1000);
//                switchToBetterCashDeskIfPossible();
//                if(cashDesk == null)
//                    break;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        while(true){
            lock.lock();
            boolean finishLock = isServed;
            lock.unlock();
            if(finishLock)
                break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.lock();
        System.out.println("Person " + getNamePerson() + " is eating");
        for (String order : orders) {
            System.out.println(order);
        }
        lock.unlock();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Person " + getNamePerson() + " leaves restaurant");


    }
}
