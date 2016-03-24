package com.exodus.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by samujjal on 16/1/16.
 */
public class MinCoins {
    public static void main(String[] args) {
        int SUM = 143;
        int sum[] = new int[SUM + 1];
        Arrays.fill(sum, Integer.MAX_VALUE);
        sum[0] = 0;
        sum[1] = 1;
        sum[2] = 2;
        sum[3] = 1;

        int coinList[] = {1,3,7};
        for (int i = 4; i <= SUM ; i++) {
            for (int j = 0; j < coinList.length; j++) {
                if(coinList[j] <= i && (sum[i - coinList[j]] + 1) < sum[i]){
                    sum[i] = sum[i-coinList[j]] + 1;
                }
            }
        }

        for (int i = 0; i < sum.length; i++) {
            System.out.println( "Sum ("+ i  + ") " +  " : " + sum[i]);
        }

    }
}
