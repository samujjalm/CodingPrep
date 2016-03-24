package com.makemytrip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by samujjal on 17/1/16.
 */
public class TshirtsSpan {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {

                line = br.readLine();

            int arr[] = new int[Integer.parseInt(line)];

            line = br.readLine();
            String str[] = line.split("\\s+");
            for (int j = 0; j < str.length; j++) {
                arr[j] = Integer.parseInt(str[j]);
            }

            printMaxRangeStartStop(arr);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printMaxRangeStartStop(int[] arr) {


        boolean state[] = new boolean[arr.length + 1];
        int start_index = 0;
        int end_index = 0;
        int max_length = 0;
        int max_length_so_far  = 0;
        int start_index_so_far = -1;
        int end_index_so_far = -1;
        for (int i = 0; i < arr.length; ) {
            if(state[arr[i]]){
                if(max_length_so_far > max_length){
                    max_length = max_length_so_far;
                    start_index = start_index_so_far;
                    end_index = end_index_so_far;
                }
                max_length_so_far = 0;
                start_index_so_far = -1;
                end_index_so_far = -1;
                state = new boolean[arr.length + 1];
                if(arr[i] != arr[i-1]){
                    i--;
                }
                if(i+1 >= arr.length || arr[i] == arr[i+1]){
                    i++;
                }


            }else {
                max_length_so_far++;
                if(start_index_so_far == -1){
                    start_index_so_far = i;
                }
                end_index_so_far = i;
                state[arr[i]] = true;
                i++;
            }
        }
        if(max_length_so_far > max_length){
            max_length = max_length_so_far;
            start_index = start_index_so_far;
            end_index = end_index_so_far;
        }

        System.out.println((start_index + 1) + " " + (end_index + 1));
    }
}
