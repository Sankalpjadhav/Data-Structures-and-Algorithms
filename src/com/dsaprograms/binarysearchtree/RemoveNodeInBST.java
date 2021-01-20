package com.dsaprograms.binarysearchtree;

import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a partially written BST class.
2. You are required to complete the body of remove function. "remove" function is expected to remove a new node with given data to the tree and return the new root.
Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
62
Sample Output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
. <- 37 -> .
. <- 75 -> 87
. <- 87 -> .
 */
public class RemoveNodeInBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int max(Node node){
        if(node.right!=null){
            return max(node.right);
        }
        else{
            return node.data;
        }
    }

    public static Node removeNodeInBST(Node node, int data){
        if(node == null){
            return null;
        }

        if(node.data > data){
            node.left = removeNodeInBST(node.left,data);
        }
        else if(node.data < data){
            node.right = removeNodeInBST(node.right,data);
        }
        else{ // Once we find the node which has to be removed.
            if(node.left==null && node.right==null) // Node has no children
            {
                return null;
            }
            else if(node.left!=null){ // Node has only left child.
                return node.left;
            }
            else if(node.right!=null){ // Node has only right child.
                return node.right;
            }
            else{ // More than 2 children
                /*
                1. Find the maximum element on the left side.
                2. Replace the given node with maximum element.
                3. Delete the left max element from the left side.
                 */
                int leftMax = max(node.left);
                node.data = leftMax;
                node.left = removeNodeInBST(node,leftMax);
                return node;
            }
        }
        return node;
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer[] array = {50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 87, null, null};
        Node root = construct(array);
        int data = sc.nextInt();
        removeNodeInBST(root,data);
        display(root);
    }
}
