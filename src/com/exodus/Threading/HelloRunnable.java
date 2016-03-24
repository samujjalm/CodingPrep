package com.exodus.Threading;

/**
 * Created by samujjal on 18/11/14.
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello Runnable Run Call");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}
