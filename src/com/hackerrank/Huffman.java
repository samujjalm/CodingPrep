package com.hackerrank;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samujjal on 13/11/15.
 */

class HNode{
    public  int frequency; // the frequency of this tree
    public  char data;
    public  HNode left, right;
}

public class Huffman {
    public static void main(String[] args) {

    }

    void decode(String S ,HNode root)
    {
        if(root ==  null){
            return;
        }
        char[] arr = S.toCharArray();
        HNode node = root;
        int i = 0;
        while(i < arr.length){
            if(arr[i] == '0'){
                node = node.left;
                if(node.data != '\0'){
                    System.out.print(node.data);
                    node = root;
                }
            }else {
                node = node.right;
                if(node.data != '\0'){
                    System.out.print(node.data);
                    node = root;
                }
            }
            i++;
        }

    }
}
