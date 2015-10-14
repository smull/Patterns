package com.levelup.model.easyProducerConsumer;

import java.util.concurrent.BlockingQueue;

/**
 * Created by SMULL on 10/14/2015.
 */
public class CashDesk extends Thread {

    private BlockingQueue<String> orders;
    private Person person;

    public CashDesk(BlockingQueue<String> orders, String threadName){
        this.orders = orders;
        setName(threadName);
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            try {
                orders.put(new String("ddd"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
