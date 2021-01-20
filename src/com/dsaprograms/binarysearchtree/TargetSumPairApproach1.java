package com.dsaprograms.binarysearchtree;

import java.util.Scanner;
import java.util.Stack;
/*
Complexity - O(nlogn), logn to find and n to visit all node once.
1. You are given a partially written BST class.
2. You are given a value. You are required to print all pair of nodes which add up to the given value.
Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order.
3. Input and Output is managed for you.
Output Format
"smaller node" "larger node"
.. all pairs that add to target on separate lines
Constraints
None
Sample Input
21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
100
Sample Output
25 75
30 70
 */
public class TargetSumPairApproach1 {
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
    public static boolean find(Node node, int data){
        if(node==null){
            return false;
        }
        if(data < node.data){
            return find(node.left, data);
        }
        else if(data > node.data){
            return find(node.right, data);
        }
        else{
            return true;
        }
    }

    public static void targetSumPair(Node root, Node node, int target){
        if(node==null){
            return ;
        }
        targetSumPair(root, node.left, target);
        int complement = target - node.data;
        if(node.data < complement){
            if(find(root, complement)==true){ // root because we need to find the element from start i.e root.
                System.out.println(node.data+" "+ complement);
            }
        }
        targetSumPair(root, node.right, target);
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        Node root = construct(array);
        int target = sc.nextInt();
        targetSumPair(root, root, target);
    }
}
