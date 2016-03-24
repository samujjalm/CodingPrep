package com.exodus.DynamicProgramming;



/**
 * Created by samujjal on 20/1/16.
 */
public class RodCutting {

    public static void main(String[] args) {
        int arr[] = {0, 3, 5, 8, 9, 10, 17, 17, 20};
        CutRod(arr);
    }

    private static void CutRod(int arr[]){

        int computedVal[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int val = 0;
            for (int j = 0; j <= i; j++) {
                val = Math.max(Math.max(arr[i-j], computedVal[i-j]) + Math.max(arr[j], computedVal[j]), val);
            }
            computedVal[i] = val;
        }

        for (int i = 0; i < computedVal.length; i++) {
            System.out.println(computedVal[i]);
        }

    }

}
