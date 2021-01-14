package com.dsaprograms.generictree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of lca function. The function is expected to return the lowest common ancestor of two data values that are passed to it.
Please watch the question video to understand what lca is.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120
80
Sample Output
80
*/

public class LowestCommonAncester {
    private static class Node {
        int data;
        ArrayList < Node > children = new ArrayList < > ();
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack< Node > st = new Stack < > ();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static ArrayList <Integer> nodeToRootPath(Node node, int data) {
        // write your code here
        if(node.data == data){
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(node.data);
            return list;
        }

        for(Node child: node.children){
            ArrayList<Integer> pathTillChild = nodeToRootPath(child,data);
            if(pathTillChild.size()>0){
                pathTillChild.add(node.data); // Add parent data
                return pathTillChild;
            }
        }

        //If none of the child has data in it then return empty arraylist
        return new ArrayList<Integer>();
    }

    public static int lca(Node node, int d1, int d2) {
        // write your code here
        /* Approach:
         1.first find node to root path for each data
         2. Traverse from the end and find the last unequal data and return last common data as answer.
        */

        ArrayList<Integer> pathForD1 = nodeToRootPath(node,d1);
        ArrayList<Integer> pathForD2 = nodeToRootPath(node,d2);
        int i = pathForD1.size()-1;
        int j = pathForD2.size()-1;
        while (i >= 0 && j >= 0 && pathForD1.get(i) == pathForD2.get(j)) {
            i--;
            j--;
        }
        i++; // since we want return common ancestor
        j++;
        return pathForD1.get(i);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int d1 = sc.nextInt();
        int d2 = sc.nextInt();

        Node root = construct(arr);
        int lca = lca(root, d1, d2);
        System.out.println(lca);
        // display(root);
    }
}
