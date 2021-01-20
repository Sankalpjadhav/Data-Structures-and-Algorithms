package com.dsaprograms.binarysearchtree;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given a partially written BST class.
2. You are required to complete the body of size, sum, max, min and find function. The functions are expected to:
    2.1. size - return the number of nodes in BST
    2.2. sum - return the sum of nodes in BST
    2.3. max - return the value of node with greatest value in BST
    2.4. min - return the value of node with smallest value in BST
    2.5. find - return true if there is node in the tree equal to "data"
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
70
Sample Output
9
448
87
12
true
 */
public class SizeSumMaxMininBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack< Pair > st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static int size(Node node) {
        // write your code here
        if(node==null){
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int totalSize = leftSize + rightSize + 1;
        return totalSize;
    }

    public static int sum(Node node) {
        // write your code here
        if(node==null){
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int total = leftSum + rightSum + node.data;
        return total;
    }

    public static int max(Node node) {
        // write your code here
        if(node.right!=null){
            return max(node.right);
        }
        else{
            return node.data;
        }
    }

    public static int min(Node node) {
        // write your code here
        if(node.left!=null){
            return min(node.left);
        }
        else{
            return node.data;
        }
    }

    public static boolean find(Node node, int data) {
        // write your code here
        if(node==null){
            return false;
        }

        if(data > node.data){
             return find(node.right,data);
        }
        else if(data < node.data){
            return find(node.left,data);
        }
        else{
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        int data = sc.nextInt();

        Node root = construct(array);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int min = min(root);
        boolean found = find(root, data);

        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(min);
        System.out.println(found);
    }
}
