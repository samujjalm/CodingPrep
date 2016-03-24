package com.interviewbit;

import java.util.*;

/**
 * Created by samujjal on 14/11/15.
 */
public class FBPractice {

    public static void main(String[] args) {
//        String input = "asasdsdsadasdadsadasdsa";
//
//        char[] carr = input.toCharArray();
//
//        Arrays.sort(carr);
//        System.out.println(new String(carr));
//        Set<String> sam = StringPermutations(new String(carr));
//        List<String> sortedList = new ArrayList(sam);
//        Collections.sort(sortedList);
//        for (String st: sortedList
//             ) {
//            System.out.println(st);
//        }
//
//        System.out.println(sortedList.indexOf(input));
        ArrayList<String> places = new ArrayList<>(
                Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        );
        System.out.println(longestCommonPrefix(places));
    }

    public static String longestCommonPrefix(List<String> a) {
        String prefix = "";
        Boolean breaker = false;
        for (int i = 0; i < a.get(0).length(); i++) {
            char c2 = a.get(0).charAt(i);
            for (int j = 1; j < a.size(); j++) {
                if(a.get(j).length() > i){
                    
                    char c1 = a.get(j).charAt(i);
                    if(c1 != c2){
                        breaker = true;
                        break;
                    }
                }else{
                    breaker = true;
                    break;
                }
            }
            if(breaker){
                break;
            }else {
                prefix += a.get(0).charAt(i);
            }
        }

        return prefix;
    }

    static void LongestCommonPrefix(String s1, String s2){
        String prefix = "";
        if(s1 == null || s2 == null){
            return;
        }
        char[] str1Arr = s1.toCharArray();
        char[] str2Arr = s2.toCharArray();
        int i = 0,j = 0;
        while (i < str1Arr.length && j < str2Arr.length){
            if(str1Arr[i] != str2Arr[j]){
                break;
            }
            prefix += str1Arr[i];
            i++;j++;

        }
        System.out.println(prefix);
    }


    public static Set<String> StringPermutations(String str){
        Set<String> permuatations =  new HashSet<>();
        int length = str.length();
        for (int i = 1; i <= length; i++) {
            String part1 = str.substring(i);
            String part2 = str.substring(0,i);
            if(part1.length() > 1){
                Set<String> list = StringPermutations(part1);
                for (String s: list
                     ) {
                    for (int j = 0; j <= s.length(); j++) {
                        permuatations.add(s.substring(0,j) +  part2 + s.substring(j));
                    }

                }
            }else{
                if(part1.length() == 1 && part2.length() >= 1){
                    permuatations.add(part1 + part2);
                    permuatations.add(part2 + part1);
                }

            }

        }
        return permuatations;
    }


    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
//            System.out.println((i + B)%(A.size()));
            int index = (i + B)%(A.size());
            ret.add(A.get(index));
        }
        return ret;
    }

}
