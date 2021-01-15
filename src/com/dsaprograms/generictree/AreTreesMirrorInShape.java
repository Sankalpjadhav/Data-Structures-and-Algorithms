package com.dsaprograms.generictree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of areMirror function. The function is expected to check if the two trees passed to it are mirror images of each other in shape (data not to be checked, just the shape of tree).
Note -> Watch the question video for clarity.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Constraints
None
Sample Input
12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
12
100 200 -1 300 500 -1 600 -1 -1 400 -1 -1
Sample Output
true
 */
public class AreTreesMirrorInShape {
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


    public static boolean areMirror(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size())// Check if the number of children are same
        {
            return false;
        }
        // Now check for every children of n1 and n2
        for(int i=0;i<n1.children.size();i++){
            int j = n2.children.size()-1-i; // n1 first child should be same that of n2 last child
            Node child1 = n1.children.get(i);
            Node child2 = n2.children.get(j);
            if(areMirror(child1,child2)==false){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        Node root1 = construct(arr1);

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }
        Node root2 = construct(arr2);
        boolean mirror = areMirror(root1, root2);
        System.out.println(mirror);
    }
}
