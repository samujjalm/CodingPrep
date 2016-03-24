package com.makemytrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samujjal on 22/11/15.
 */
public class Tester {

    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCases = Integer.parseInt(line);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String[] inputs = line.split(" ");
            int P = Integer.parseInt(inputs[0]);
            int Q = Integer.parseInt(inputs[1]);
            int R = Integer.parseInt(inputs[2]);
            int counter = 0;
            boolean left = true;
            if((Q - P) > (R - Q)){
                left = false;
            }
            while (!((P+1) == Q && (Q+1) == R) ){
                if(left){
                    P = R - 1;
                    int temp = P;

                    P = Q;
                    Q = temp;
                    left = false;
                }else {
                    R = P + 1;
                    int temp = R;
                    R = Q;
                    Q = temp;
                    left = true;
                }
                counter++;
            }
            results.add(counter);
        }
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

    }
}
