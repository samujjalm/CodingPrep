package com.hackerrank;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by samujjal on 8/11/15.
 */

 class TNode{
    int data;
    TNode left;
    TNode right;
}

public class Tree {

    static TNode lca(TNode root,int v1,int v2)
    {
        if(root == null){
            return null;
        }
        if(root.data <= v2 && root.data >= v1){
            return root;
        }
        if(root.data > v2){
            return lca(root.left, v1, v2);
        }else {
            return lca(root.right, v1, v2);
        }

    }

    int height(TNode root)
    {
        if(root == null){
            return 0;
        }
        int height = 0;
        height = Math.max(height(root.left), height(root.right)) + 1;
        return height;
    }

    static TNode Insert(TNode root,int value)
    {
        if(root == null){
            root = new TNode();
            root.data = value;
            return root;
        }

        if(root.data == value){
            return root;
        }
        if(root.data > value){
            root.left = Insert(root.left, value);
        } else {
            root.right = Insert(root.right, value);
        }
        return root;
    }

    void LevelOrder(TNode root)
    {
        Queue<TNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        else{
            return;
        }

        while (queue.size() > 0){
            TNode dequedNode = queue.remove();
            System.out.print(dequedNode.data + " ");
            if(dequedNode.left != null){
                queue.add(dequedNode.left);
            }
            if(dequedNode.right != null){
                queue.add(dequedNode.right);
            }
        }


    }

    void top_view(TNode root)
    {
        if(root == null){
            return;
        }
        printTopViewNode(root.left, Boolean.FALSE);
        System.out.println(root.data);
        printTopViewNode(root.right, Boolean.TRUE);
    }

    void printTopViewNode(TNode node, boolean direction){
        if(node == null){
            return;
        }
        if(direction == Boolean.FALSE){
            printTopViewNode(node.left, direction);
        }else {
            printTopViewNode(node.right, direction);
        }
        System.out.println(node.data);
    }
}
