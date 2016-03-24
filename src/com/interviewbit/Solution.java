package com.interviewbit;

import java.util.*;

/**
 * Created by samujjal on 26/09/15.
 */
public class Solution {

    public static ArrayList<Integer> sieve(int a) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        Boolean[] array = new Boolean[a +1];
        Arrays.fill(array, Boolean.TRUE);

        for (int i = 4; i <= a; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (array[i] && array[j] && i % j == 0) {
                    array[i] = Boolean.FALSE;
                    continue;
                }
            }
        }

        for (int i = 2; i < array.length; i++) {
            if (array[i]) {
                primes.add(i);
            }

        }
        return primes;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = sieve(100000);
        for (Integer i : primes){
            System.out.println(i);
        }
    }

}
