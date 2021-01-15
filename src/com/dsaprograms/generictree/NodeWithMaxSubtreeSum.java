package com.dsaprograms.generictree;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to find and print the node which has the subtree with largest sum. Also print the sum of the concerned subtree separated from node's value by an '@'.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
@
Constraints
None
Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
30@130
 */
public class NodeWithMaxSubtreeSum {
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

    static int maxSumNode = 0;
    static int maxSum = 0;
    public static int returnSumAndCalculateMaxSubtreeSum(Node node) {
        int sum = 0;

        for (Node child: node.children) {
            int childSum = returnSumAndCalculateMaxSubtreeSum(child);
            sum += childSum;
        }
        sum += node.data;

        if (sum > maxSum) {
            maxSum = sum;
            maxSumNode = node.data;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = construct(arr);
        returnSumAndCalculateMaxSubtreeSum(root);
        System.out.println(maxSumNode+"@"+maxSum);
    }

}
