package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created by samujjal on 16/1/16.
 */
public class MostDistant {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        int[][] arr = new int[testCases][2];
        double maxDistance = 0;
        long maxDiff = Long.MIN_VALUE;
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String[] coordinate = line.split("\\s+");
            arr[i] = new int[]{Integer.parseInt(coordinate[0]), Integer.parseInt(coordinate[1])};

            for (int k = 0; k <= i; k++) {
                for (int j = k + 1; j < i; j++) {
                    long longDiff = arr[k][0] - arr[j][0];
                    long latDiff = arr[k][1] - arr[j][1];
                    if(maxDiff < Math.abs(longDiff) + Math.abs(latDiff)) {
                        maxDiff = Math.abs(longDiff) + Math.abs(latDiff);
                        longDiff = longDiff * longDiff;

                        latDiff = latDiff * latDiff;
                        double difference = Math.sqrt(longDiff + latDiff);
                        if (difference > maxDistance) {
                            maxDistance = difference;
                        }
                    }
                }
            }
        }

//        DecimalFormat myFormatter = new DecimalFormat("#.############");
//        String output = myFormatter.format(maxDistance);
        System.out.println(maxDistance);
    }
}
