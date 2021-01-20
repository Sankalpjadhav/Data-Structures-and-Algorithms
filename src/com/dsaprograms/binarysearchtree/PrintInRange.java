package com.dsaprograms.binarysearchtree;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given a partially written BST class.
2. You are required to complete the body of pir function. "pir" function is expected to print all nodes between d1 and d2 (inclusive and in increasing order).
3. Input and Output is managed for you.
Sample Input
21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
12
65
Sample Output
12
25
30
37
50
60
62
 */
public class PrintInRange {
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

    public static void printInRange(Node node, int data1, int data2){
        if(node==null){
            return ;
        }
        if(data1 < node.data && data2 < node.data){
            printInRange(node.left, data1, data2);
        }
        else if(data1 > node.data && data2 > node.data){
            printInRange(node.right, data1, data2);
        }
        else{ // In range
            printInRange(node.left, data1, data2);
            System.out.println(node.data);
            printInRange(node.right, data1, data2);
        }
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        Node root = construct(array);
        int data1 = sc.nextInt();
        int data2 = sc.nextInt();
        printInRange(root, data1, data2);
    }
}



