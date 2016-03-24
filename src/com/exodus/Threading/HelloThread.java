package com.exodus.Threading;

/**
 * Created by samujjal on 14/12/14.
 */
public class HelloThread extends Thread {
    public void run() {
        System.out.println("Hello From a Thread");

    }

    public static void main(String args[]) {
        (new HelloThread()).start();
    }
}
