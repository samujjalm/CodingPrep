package com.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.hackerrank.GainSight.StringSimilarity;
import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * Created by samujjal on 26/1/16.
 */
public class Fidelity2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = "/home/samujjal/fidelity.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine());
        String[] _arr = new String[_arr_size];
        String _arr_item;
        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            try {
                _arr_item = in.nextLine();
            }catch (Exception e){
                _arr_item = null;
            }
            _arr[_arr_i] = _arr_item;
        }

        res = max_dark(_arr);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    static String max_dark(String[] arr) {
        int rowLength = arr.length;
        int colLength = arr[0].split("\\s").length;
        int[][] M = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            String[] entries = arr[i].split("\\s");
            for (int j = 0; j < colLength; j++) {
                M[i][j] = Integer.parseInt(entries[j]) == 1 ? 0 : 1 ;
            }
        }

        int[][] S = new int[rowLength][colLength];
        for (int i = 0; i < colLength; i++) {
            S[0][i] = M[0][i];
        }
        for (int i = 0; i < rowLength; i++) {
            S[i][0] = M[i][0];
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if(M[i][j] == 1){
                    S[i][j] = Math.min(S[i-1][j], Math.min(S[i][j-1], S[i-1][j-1])) + 1;
                }else{
                    S[i][j] = 0;
                }
            }
        }

        int max_of_s = S[0][0], max_i = 0, max_j = 0;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if(max_of_s < S[i][j]){
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return (( (max_i * max_j) + " " + (((max_i * max_j)/(rowLength*colLength))*100)));
    }
}
