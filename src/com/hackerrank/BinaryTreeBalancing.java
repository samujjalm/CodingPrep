package com.hackerrank;

/**
 * Created by samujjal on 1/12/15.
 */

class AVLNode{
    int val;   //Value
    int ht;      //Height
    AVLNode left;   //Left child
    AVLNode right;   //Right child
};

public class BinaryTreeBalancing {
    public static void main(String[] args) {
        AVLNode root = null;
        root = insert(root, 20);
        root = insert(root, 25);
        root = insert(root, 15);
        root = insert(root, 7);
        root = insert(root, 4);
        printInorder(root);
    }

    static void printInorder(AVLNode root){
        if(root == null){
            return;
        }
        printInorder(root.left);
        System.out.println("Root Value: " + root.val + " Height: " + root.ht);
        printInorder(root.right);
    }

    static AVLNode insert(AVLNode root,int val)
    {
        root = insertAvlNode(root, val, -1);
        balanceTree(root);

        return root;
    }

    private static AVLNode insertAvlNode(AVLNode root, int val, int parentHeight) {
        if(root == null){
            root = new AVLNode();
            root.ht = parentHeight + 1;
            root.val = val;
            return root;
        }
        if (root.val < val){
            root.right = insertAvlNode(root.right, val, root.ht);
        }
        else {
            root.left = insertAvlNode(root.left,val, root.ht);
        }
        return root;
    }

    private static void balanceTree(AVLNode root) {

    }
}
