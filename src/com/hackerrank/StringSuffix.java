package com.hackerrank;


/**
 * Created by samujjal on 7/1/16.
 */
public class StringSuffix {

    private static int numberofsameelements(String input){
        int len = 0;
        for (int i = 0; i < input.length() - 1; i++) {
            if(input.charAt(i) == input.charAt(i+1)){
                len++;
            }else{
                break;
            }
        }

        return len;

    }

    private static int getmatchlength(String input, String s) {
        int retVal = 0;
        for (int i = 0; i < input.length() && i < s.length(); i++) {
            if(input.charAt(i) == s.charAt(i)){
                retVal++;
            }else {
                break;
            }
        }
        return retVal;
    }

    private static int sumofvaluestillN(int N){
        if(N <= 1){
            return 0;
        }
        return N + sumofvaluestillN(N-1);
    }

    public static void main(String[] args) {
        String input = "aa";

        int commonstartlength = numberofsameelements(input);
        int finalValue = 0;
        if (commonstartlength == 0){
            finalValue = input.length();
        }else{
            finalValue = input.length() + sumofvaluestillN(commonstartlength);
        }
        int start = commonstartlength == 0 ? 1 : commonstartlength;
        for (int i = start; i < input.length(); i++) {
            int matchLength = getmatchlength(input, input.substring(i));
            System.out.println(input.substring(i) + "  : " + matchLength);
            finalValue += matchLength;
        }

        System.out.println("final length : " + finalValue);
    }




}
