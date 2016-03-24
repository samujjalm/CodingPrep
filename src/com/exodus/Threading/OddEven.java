package com.exodus.Threading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by samujjal on 24/1/16.
 */
public class OddEven {
    public static void main(String[] args) throws InterruptedException {
        Appetite appetite = new Appetite();
        appetite.Main();
    }
}

class Appetite{
    Integer counter = 1;
    Object lock = new Object();
    public void Main() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(40);
        for (int i = 0; i < 40; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        LockandPrintOdd();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        LockandPrintEven();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);

        System.out.println("finished");
    }

    private void LockandPrintOdd() throws InterruptedException {
        synchronized (lock){
            if(counter%2 == 0){
                lock.wait();
            }
            Thread.sleep(new Random().nextInt(1000));
            System.out.println(counter);
            counter++;
            lock.notifyAll();
        }
    }

    private void LockandPrintEven() throws InterruptedException {
        synchronized (lock){
            if(counter%2 == 1){
                lock.wait();
            }

            Thread.sleep(new Random().nextInt(2000));
            System.out.println(counter);
            counter++;
            lock.notifyAll();
        }
    }
}


