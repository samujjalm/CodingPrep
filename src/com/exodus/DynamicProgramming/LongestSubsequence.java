package com.exodus.DynamicProgramming;

/**
 * Created by samujjal on 16/1/16.
 */
public class LongestSubsequence {
    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 20, 80 };
        int LS[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            LS[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i] >= arr[j] && LS[i] <= LS[j]){
                    LS[i] = LS[j] + 1;
                }
            }
        }
        if(LS[1] > LS[0]){
            System.out.println(" 0 : "+ arr[0] + ", ");
        }

        for (int i = 1; i < arr.length; i++) {
            if(LS[i] > LS[i-1])
                System.out.println(i+ " : "+ arr[i] + ", ");
        }
    }
}
