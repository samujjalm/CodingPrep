package com.exodus.Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by samujjal on 21/1/16.
 */
public class MultipleLocks {
    public static void main(String[] args) {
        AppList appList = new AppList();
        appList.Main();
    }
}

class AppList {
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    Object o1 = new Object();
    Object o2 = new Object();
    private Random random = new Random();
    private void IncreaseList1(){
        synchronized (o1){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list1.add(random.nextInt(100));
        }

    }

    private void IncreaseList2(){
        synchronized (o2){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            list2.add(random.nextInt(100));
        }

    }

    private void Process(){
        for (int i = 0; i < 1000; i++) {
            IncreaseList1();
            IncreaseList2();
        }

    }

    public void Main(){
        long startSecs = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Process();
            }
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endSecs = System.currentTimeMillis();

        System.out.println("Time taken: " + (endSecs - startSecs));
        System.out.println("List 1 Length: " + list1.size());
        System.out.println("List 2 Length: " + list2.size());

    }

}
