package com.exodus.DynamicProgramming;

/**
 * Created by samujjal on 26/1/16.
 */
public class MinCost {
    public static void main(String[] args) {

        //TODO: Implement Memoization for O(mn) complexity
        int[][] array = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };

        int minSum = MinSumPath(array, 0, 0);

        System.out.println(minSum);
    }

    private static int MinSumPath(int[][] array, int row, int col) {
        if(row == array.length || col == array[0].length ){
            return array[array.length-1][array[0].length-1];
        }
        int sum = Math.min(MinSumPath(array, row + 1, col + 1),
                Math.min(MinSumPath(array, row + 1, col), MinSumPath(array, row, col+1))) + array[row][col];

//        System.out.println("row : " + row + " col : " + col + " sum: " + sum);
        return sum;
    }
}
