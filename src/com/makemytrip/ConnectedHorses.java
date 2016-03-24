package com.makemytrip;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samujjal on 22/11/15.
 */
class Coordinate{
    public int getP() {
        return P;
    }

    int P;

    public int getQ() {
        return Q;
    }

    int Q;
    public Coordinate(int p, int q){
        P = p;
        Q = q;
    }

}
public class ConnectedHorses {

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
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);
            boolean array[][] = new boolean[N][M] ;
            int horses = Integer.parseInt(inputs[2]);
            List<Coordinate> horseLocations = new ArrayList<>();
            for (int j = 0; j < horses; j++) {
                line = br.readLine();
                int p = Integer.parseInt(line.split(" ")[0]);
                int q = Integer.parseInt(line.split(" ")[1]);
                array[p][q] = true;
                horseLocations.add(new Coordinate(p,q));
            }
            int counter = 0;
            for (int j = 0; j < horseLocations.size(); j++) {
                Coordinate location = horseLocations.get(i);
                int p = location.getP();
                int q = location.getQ();
                p--;
                q++;
                while (p >= 0 && p < N && q >= 0 && q < M){
                    if(array[p][q]){
                        counter++;
                    }
                    p--;
                    q++;
                }
                p = location.getP();
                q = location.getQ();
                p++;
                q--;
                while (p >= 0 && p < N && q >= 0 && q < M){
                    if(array[p][q]){
                        counter++;
                    }
                    p++;
                    q--;
                }

                p = location.getP();
                q = location.getQ();
                p--;
                q--;
                while (p >= 0 && p < N && q >= 0 && q < M){
                    if(array[p][q]){
                        counter++;
                    }
                    p--;
                    q--;
                }


                p = location.getP();
                q = location.getQ();
                p++;
                q++;
                while (p >= 0 && p < N && q >= 0 && q < M){
                    if(array[p][q]){
                        counter++;
                    }
                    p++;
                    q++;
                }
            }
            results.add(counter);
        }
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }
}
