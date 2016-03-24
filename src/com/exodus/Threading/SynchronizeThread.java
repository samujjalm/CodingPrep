package com.exodus.Threading;

/**
 * Created by samujjal on 21/1/16.
 */
public class SynchronizeThread {
    public static void main(String[] args) {
        App app = new App();

        app.Main();

    }



}

 class App{
    private int val = 0;

     private synchronized void increment(){
         val++;
     }
    public void Main(){

        Thread first = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });
        Thread second = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });
        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(val);
    }
}

