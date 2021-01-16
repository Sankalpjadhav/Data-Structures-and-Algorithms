package com.dsaprograms.generictree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given a partially written GenericTree class.
2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
diameter
Constraints
None
Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
4
 */
//Maximum length between two nodes.
public class DiameterOfTree {
    private static class Node {
        int data;
        ArrayList< Node > children = new ArrayList < > ();
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
    static int diameter = 0;
    public static int calculateDiameterByReturningHeight(Node node){
        // Approach is to calculate maximum two heights of a node
        int firstDeepestChild = -1;
        int secondDeepestChild = -1;

        for(Node child: node.children){
            int childHeight =   calculateDiameterByReturningHeight(child);
            if(childHeight > firstDeepestChild){
                secondDeepestChild = firstDeepestChild;
                firstDeepestChild = childHeight;
            }
            else if(childHeight > secondDeepestChild){
                secondDeepestChild = childHeight;
            }
        }

        if(firstDeepestChild + secondDeepestChild +2 > diameter){
            diameter = firstDeepestChild + secondDeepestChild + 2; // Add two edges for root.
        }

        firstDeepestChild += 1; // For a single node, add 1 to it becoz wrt root.
        return firstDeepestChild;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        calculateDiameterByReturningHeight(root);
        System.out.println("Diameter of tree(Maximum distance between two nodes) is: "+diameter);
    }
}
