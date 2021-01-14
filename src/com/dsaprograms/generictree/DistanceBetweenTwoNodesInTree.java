package com.dsaprograms.generictree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of distanceBetweenNodes function. The function is expected to return the distance (in terms of number of edges) between two nodes in a generic tree.
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
100
110
Sample Output
5
 */
public class DistanceBetweenTwoNodesInTree {
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

    public static ArrayList < Integer > nodeToRootPath(Node node, int data) {
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


    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        // write your code here
        ArrayList<Integer> pathOfD1 = nodeToRootPath(node,d1);
        ArrayList<Integer> pathOfD2 = nodeToRootPath(node,d2);
        int i=pathOfD1.size()-1;
        int j=pathOfD2.size()-1;
        while(i>=0 && j>=0 && pathOfD1.get(i)==pathOfD2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return i+j;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        int dist = distanceBetweenNodes(root, d1, d2);
        System.out.println(dist);
        // display(root);
    }
}
