package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by samujjal on 7/1/16.
 */
public class GainSight {

    static int[] StringSimilarity(String[] inputs) {
        int[] retArrays = new int[inputs.length];
        for (int input = 0; input < inputs.length; input++) {
            int finalValue = inputs[input].length();
            for (int i = 1; i < inputs[input].length(); i++) {
                int matchLength = getmatchlength(inputs[input], inputs[input].substring(i));
                System.out.println(inputs[input].substring(i) + "  : " + matchLength);
                finalValue += matchLength;
            }
            retArrays[input] = finalValue;
            System.out.println("final length : " + finalValue);

        }

        return  retArrays;
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


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = "/home/samujjal/gainsight.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        int _inputs_size = 0;
        _inputs_size = Integer.parseInt(in.nextLine());
        String[] _inputs = new String[_inputs_size];
        String _inputs_item;
        for (int _inputs_i = 0; _inputs_i < _inputs_size; _inputs_i++){
            try {
                _inputs_item = in.nextLine();
            }
            catch (Exception e){
                _inputs_item = null;
            }
            _inputs[_inputs_i] = _inputs_item;
        }

        res = StringSimilarity(_inputs);
        for (int res_i=0; res_i < res.length; res_i++){
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }
        bw.close();
    }
}
