package com.exodus;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("sam");
        int[] array = {10,20,30,40,50,60,71,80,90,91};
        TreeHelper.PrintInOrder(TreeHelper.BuildTestTree(array, 0));
        TreeHelper.PrintIterativeInOrder(TreeHelper.BuildTestTree(array, 0));
        System.out.println(TreeHelper.GetMaxHeight(TreeHelper.BuildTestTree(array, 0)));
    }
}
