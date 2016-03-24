package com.exodus.Threading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by samujjal on 24/1/16.
 */
public class Airport {

    public static void main(String[] args) {
        AirController controller = new AirController();
        try {
            controller.Main();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

class AirController{
    Semaphore runaways = new Semaphore(1);
    public void  Main() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 30; i++) {
            executor.submit(new AirPlane(i, runaways));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}


class AirPlane implements Runnable{
    int id;
    Semaphore runaways;
    public AirPlane(int id, Semaphore runaways){
        this.id = id;
        this.runaways = runaways;
    }

    @Override
    public void run() {
        try {
            runaways.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Initiate Landing : " + id + " Permits Remaining : " + runaways.availablePermits());
        try {
            Thread.sleep(new Random().nextInt(2000));
            System.out.println("Landing Completed: " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            runaways.release();
        }

    }
}


