package com.exodus;

/**
 * Created by samujjal on 30/03/15.
 */

class TrieNode{
    int value;
    TrieNode[] children;
    public TrieNode(){
        value = 0;
        children = new TrieNode[26];
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
    }
}

public class Trie {
    TrieNode root;
    int count = 0;
    public void add(String input){
        if (root == null){
            root = new TrieNode();
        }
        TrieNode curr = root;
        count++;
        for (char ch : input.toCharArray()){
            int index = (int)ch - (int)'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.value = count;
    }

    public boolean search(String input){
        if (root == null) return false;
        TrieNode curr = root;
        for (char ch : input.toCharArray()){
            if (curr.children[((int)ch - (int)'a')] == null) return false;
            curr = curr.children[((int)ch - (int)'a')];
        }
        return  (curr.value != 0);
    }
}
