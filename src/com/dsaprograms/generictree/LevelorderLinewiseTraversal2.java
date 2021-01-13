package com.dsaprograms.generictree;
import java.util.*;
// Using single queue data structure
public class LevelorderLinewiseTraversal2 {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList< >();
        Node(){ // Default constructor

        }
        Node(int data){
            this.data = data;
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack< >();
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

    public static void levelOrder2(Node node) {
        // write your code here
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        queue.add(new Node(-1));
        while (queue.size()>0){
            node = queue.remove();
            if(node.data!=-1) {
                System.out.print(node.data + " ");

                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            else {
                if (queue.size() > 0) {
                    queue.add(new Node(-1));
                    System.out.println();
                }
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
        levelOrder2(root);
    }
}
