package com.exodus;

import java.util.*;

/**
 * Created by samujjal on 26/10/14.
 */
public class TreeHelper {

    static TreeNode BuildTestTree(int[] arr, int index) {
        if (index >= arr.length)
            return null;
        TreeNode root = new TreeNode();
        root.setData(arr[index]);
        root.setLeft(BuildTestTree(arr, 2 * index + 1));
        root.setRight(BuildTestTree(arr, 2 * index + 2));
        return root;

    }

    static int GetMaxHeight(TreeNode root){

        if(root == null){
            return 0;
        }
        return Math.max(GetMaxHeight(root.getLeft()), GetMaxHeight(root.getRight())) + 1;
    }



    static void PrintInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        PrintInOrder(root.getLeft());
        System.out.println(root.getData());
        PrintInOrder(root.getRight());
    }

    static void PrintIterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        if (root != null) {
            stack.push(root);
            node = root.getLeft();
            while (!stack.empty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                }
                node = stack.pop();
                System.out.println(node.getData());
                node = node.getRight();
            }
        }
    }
}
