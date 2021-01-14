package com.dsaprograms.generictree;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of areSimilar function. The function is expected to check if the two trees passed to it are similar in shape or not.
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
24
1 2 5 -1 6 -1 -1 3 7 -1 8 11 -1 12 -1 -1 9 -1 -1 4 10 -1 -1 -1
Sample Output
true
 */
public class AreTreesSimilarInShape {
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


    public static boolean areSimilar(Node n1, Node n2) {
        // write your code here
        if(n1.children.size()!=n2.children.size()){
            return false;
        }
        for(int i=0;i<n1.children.size();i++){
            Node first = n1.children.get(i);
            Node second = n2.children.get(i);
            if(areSimilar(first,second)==false){
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

        boolean similar = areSimilar(root1, root2);
        System.out.println(similar);
    }
}
