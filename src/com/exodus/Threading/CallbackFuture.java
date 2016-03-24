package com.exodus.Threading;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by samujjal on 21/1/16.
 */
public class CallbackFuture {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Starting...");
                Random random = new Random();
                int duration = random.nextInt(4000);
                if(duration > 2000){
                    throw new IOException("Sleeping too long");
                }
                Thread.sleep(duration);

                System.out.println("Finished");
                return duration;
            }
        });

        executor.shutdown();
        try {
            System.out.println("Duration is ... " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            IOException exception = (IOException) e.getCause();
            System.out.println(exception.getMessage());
        }
    }
}
