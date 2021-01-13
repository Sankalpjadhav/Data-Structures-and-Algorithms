package com.dsaprograms.generictree;
/*
1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWise function.
The function is expected to visit every node in "levelorder fashion" and print them from left to right (level by level).
All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
All nodes from left to right (level by level) all separated by a space.
All levels on separate lines starting from top to bottom.
Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
Sample Output
10
20 30 40
50 60 70 80 90 100
110 120
 */
import java.util.*;

public class LevelorderLinewiseTraversal {
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

    public static void levelOrder(Node node) {
        // write your code here
        Queue<Node> queueParent = new ArrayDeque<>();
        Queue<Node> queueChild = new ArrayDeque<>();

        queueParent.add(node);
        while(queueParent.size()>0){
            Node val = queueParent.remove();
            System.out.print(val.data+" ");
            for(Node child: val.children){
                queueChild.add(child);
            }
            if(queueParent.size()==0){
                System.out.println();
                queueParent = queueChild;
                queueChild = new ArrayDeque<>();
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
        levelOrder(root);
    }
}
