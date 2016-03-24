package com.interviewbit;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by samujjal on 5/10/15.
 */
public class Sieve {
    public static ArrayList<Integer> range_sieve(int start, int end) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        Boolean[] array = new Boolean[end+1];
        Arrays.fill(array, Boolean.TRUE);

        for (int i = 4; i <= end; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (array[i] && array[j] && i % j == 0) {
                    array[i] = Boolean.FALSE;
                    continue;
                }
            }
        }

        for (int i = start; i < array.length; i++) {
            if (array[i]) {
                primes.add(i);
            }

        }
        return primes;
    }
}
