package com.exodus.DynamicProgramming;

/**
 * Created by samujjal on 17/1/16.
 */
public class EditDistance {

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(getChangeCount(str1, str2, str1.length(), str2.length()));
    }

    private static int getChangeCount(String str1, String str2, int m1, int m2) {
        if(m1 == 0)
            return m2;

        if(m2 == 0)
            return m1;

        int length;
        if(str1.toCharArray()[m1-1] == str2.toCharArray()[m2-1]){
            length = getChangeCount(str1, str2, m1-1, m2-1);
        }else{
            length = 1 + Min(getChangeCount(str1, str2, m1-1, m2),
                    getChangeCount(str1, str2, m1, m2-1),
                    getChangeCount(str1, str2, m1-1, m2-1));
        }
        return length;

    }

    private static int Min(int changeCount, int changeCount1, int changeCount2) {
        return Math.min(changeCount, Math.min(changeCount1, changeCount2));
    }


}
