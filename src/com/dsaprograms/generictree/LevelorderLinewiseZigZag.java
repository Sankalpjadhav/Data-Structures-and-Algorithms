package com.dsaprograms.generictree;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWiseZigZag function. The function is expected to visit every node in "levelorder fashion" but in a zig-zag manner i.e. 1st level should be visited from left to right, 2nd level should be visited from right to left and so on. All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
3. Input is managed for you.

Input Format
Input is managed for you
Output Format
All nodes on the same level should be separated by a space.
1st level should be visited left to right, 2nd from right to left and so on alternately.
All levels on separate lines starting from top to bottom.
Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
Sample Output
10
40 30 20
50 60 70 80 90 100
120 110
 */
public class LevelorderLinewiseZigZag {
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
    public static void levelOrderLinewiseZigZag(Node node) {
        // write your code here
        Stack<Node> mainStack = new Stack <Node>();
        Stack<Node> childStack = new Stack <Node>();
        mainStack.push(node);
        int level= 1; // for odd level add into child from left to right and for even level from right to left.
        while(mainStack.size()>0){
            Node val = mainStack.pop();
            System.out.print(val.data+" ");
            if(level%2==1){ //odd
                for(int i=0;i<val.children.size();i++){
                    Node child = val.children.get(i);
                    childStack.add(child);
                }
            }
            else { //Even
                for(int i=val.children.size()-1;i>=0;i--){
                    Node child = val.children.get(i);
                    childStack.add(child);
                }
            }

            if(mainStack.size()==0){
                mainStack = childStack;
                childStack = new Stack <Node>();
                level++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr);
        levelOrderLinewiseZigZag(root);
    }
}
