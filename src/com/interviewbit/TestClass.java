package com.interviewbit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by samujjal on 5/10/15.
 */
public class TestClass {
    public static void main(String args[] ) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        List<Integer> primes = new ArrayList<>();
        Integer lastEnd = -1;
        int N = Integer.parseInt(line);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String[] numbers = line.split(" ");
            for (int j = 0; j < numbers.length; j++) {
                list.add(Integer.parseInt(numbers[j]));
            }
        }
        for (int i = 0; i < 2*N; i += 2) {
            int pairs = 0;
            int start = list.get(i);
            int end = list.get(i+1);

            if(start <= 2){
                if(lastEnd < end){
                    range_sieve(start, end, primes);
                    lastEnd = end;
                }

                for(Integer num : primes){
                    if((primes.contains(num + 2)) || isPrime(num + 2)){
                        pairs++;
                    }
                }
            }

            System.out.println(pairs);
        }

        System.exit(0);

    }

    public static boolean isPrime(int a) {
        if(a == 0 || a == 1){
            return false;
        }
        for (int i =2; i <= Math.sqrt(a); i++){
            if(a%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void range_sieve(int start, int end, List<Integer> primes) {

        Boolean[] array = new Boolean[end+1];

        Arrays.fill(array, Boolean.TRUE);
        array[0] = Boolean.FALSE;
        array[1] = Boolean.FALSE;
        int last = 4;
        if(primes.size() > 0){
            last = primes.get(primes.size()-1) + 1;
            start = last;
        }
        for (int i = last; i <= end; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (array[i] && array[j] && i % j == 0) {
                    array[i] = Boolean.FALSE;
                    continue;
                }
            }
        }


        for (int i = start; i <= end; i++) {

            if (array[i]) {
                primes.add(i);
            }

        }
        return;
    }
}
