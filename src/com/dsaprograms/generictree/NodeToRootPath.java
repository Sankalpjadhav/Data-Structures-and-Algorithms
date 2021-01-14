package com.dsaprograms.generictree;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of nodeToRootPath function. The function is expected to return in form of linked list the path from element to root, if the element with data is found.
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
Sample Output
[120, 80, 30, 10]
 */
public class NodeToRootPath {
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

    public static ArrayList< Integer > nodeToRootPath(Node node, int data) {
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
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int data = sc.nextInt();

        Node root = construct(arr);
        ArrayList < Integer > path = nodeToRootPath(root, data);
        System.out.println(path);
        // display(root);
    }
}
