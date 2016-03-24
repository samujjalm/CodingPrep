package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Created by samujjal on 26/1/16.
 */
public class Fidelity {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = br.readLine();
            int testCases = Integer.parseInt(line);
            int results[] = new int[testCases];
            for (int i = 0; i < testCases; i++) {

                line = br.readLine();

                int arr[] = new int[Integer.parseInt(line)];
                line = br.readLine();
                String[] entries = line.split("\\s");
                for (int j = 0; j < entries.length; j++) {
                    arr[j] = Integer.parseInt(entries[j]);
                }
                int output = arr[0];
                for (int j = 1; j < arr.length; j++) {
                    output ^= arr[j];
                }

                if(output == 0){
                    results[i] = 1;
                }else {
                    results[i] = 0;
                }
            }

            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }

    }
}
