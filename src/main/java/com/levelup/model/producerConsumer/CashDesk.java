package com.levelup.model.producerConsumer;


import java.util.Deque;
import java.util.LinkedList;


/**
 * Created by SMULL on 10/14/2015.
 */
public class CashDesk extends Thread {

    private Deque<Person> people;
    private int numberIDCash;
    private int timeOfServiceOrders;

    public CashDesk(int numberIDCash, int timeOfServiceOrders) {
        this.numberIDCash = numberIDCash;
        this.timeOfServiceOrders = timeOfServiceOrders;
        people = new LinkedList<Person>();
    }

    public int getNumberIDCash() {
        return numberIDCash;
    }

    public Deque<Person> getPeople() {
        return people;
    }

    @Override
    public void run() {
        while (true) {
            Person person = null;
            try {
                if (people.size() > 0) {
                    person = people.removeFirst();
                }
                if (person == null) {
                    Thread.sleep(1000);
                    continue;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            servePerson(person);
        }
    }

    private void servePerson(Person person) {
        System.out.println("Person " + person.getNamePerson() +
                " is serving on cahsDesk#" + getNumberIDCash());

        if (!person.startServe(this))
            return;
        try {
            Thread.sleep(timeOfServiceOrders * person.getOrders().size());
            person.finishServe(this);
            System.out.println("Person " + person.getNamePerson() + " is served");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public synchronized void addPerson(Person person) {
            people.addLast(person);
    }

    public synchronized void removePerson(Person person) {
        people.remove(person);
    }
}
