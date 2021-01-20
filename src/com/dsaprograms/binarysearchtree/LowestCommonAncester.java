package com.dsaprograms.binarysearchtree;

import java.util.Scanner;
import java.util.Stack;

public class LowestCommonAncester {
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

    public static int lowestCommonAncester(Node node, int data1, int data2){
        if(node==null){
            return 0;
        }
        if(data1 < node.data && data2 < node.data){
            return lowestCommonAncester(node.left, data1, data2);
        }
        else if(data1 > node.data && data2 > node.data){
            return lowestCommonAncester(node.right, data1, data2);
        }
        else{ // when it is equal return the current node data
            return node.data;
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer[] array = {50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 87, null, null};
        Node root = construct(array);
        int data1 = sc.nextInt();
        int data2 = sc.nextInt();
        int lca = lowestCommonAncester(root, data1, data2);
        System.out.println(lca);
    }
}


