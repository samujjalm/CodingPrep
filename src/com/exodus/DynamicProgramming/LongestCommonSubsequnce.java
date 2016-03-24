package com.exodus.DynamicProgramming;


/**
 * Created by samujjal on 17/1/16.
 */
public class LongestCommonSubsequnce {
    public static void main(String[] args) {
        System.out.println(lcs("ABCDGH", "AEDFHR"));
    }

    private static int lcs(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int lcsLength = 0;
        if (m > 0 && n > 0) {
            String str1Next = str1.substring(0, m - 1);
            String str2Next =  str2.substring(0, n - 1);
            if (str1.toCharArray()[m - 1] == str2.toCharArray()[n - 1]) {
                lcsLength = 1 + lcs(str1Next, str2Next);
            } else {
                lcsLength = Math.max(lcs(str1Next,str2),
                        lcs(str1,str2Next));
            }

        }


        return lcsLength;
    }
}
