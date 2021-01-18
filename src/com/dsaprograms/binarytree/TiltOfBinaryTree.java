package com.dsaprograms.binarytree;

import java.util.Stack;
/*
1. You are given a partially written BinaryTree class.
2. You are required to complete the body of tilt function. The function is expected to set the value of data member "tilt".
"tilt" of a node is the absolute value of difference between sum of nodes in it's left subtree and right subtree.
 "tilt" of the whole tree is represented as the sum of "tilt"s of all it's nodes.
3. Input and Output is managed for you.
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Sample Output
390
 */
public class TiltOfBinaryTree {
    // Class Node
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    // Class Pair
    static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    static int tilt = 0;
    static int tiltOfBinaryTree(Node node){
        if(node == null){
            return 0;
        }

        // Will return sum of left child, which helps in calculating tilt.
        int leftSum = tiltOfBinaryTree(node.left);
        // Will return sum of right child, which helps in calculating tilt.
        int rightSum = tiltOfBinaryTree(node.right);

        int tiltAbsolute = Math.abs(leftSum - rightSum);
        tilt+=tiltAbsolute;

        int tiltSum = leftSum + rightSum + node.data;
        return tiltSum;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        /*
        State:
        1 indicates: next node to be entered at left position.
        2 indicates: next node to be entered at right position.
        3 indicates: pop from the stack.
         */
        Node root = new Node(array[0], null, null);
        Pair rootPair = new Pair(root, 1);
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(rootPair);
        int index = 0; // Index to access array elements.
        while (!stack.empty()) {
            Pair top = stack.peek();
            if (top.state == 1) {
                index++;
                if (array[index] != null) {
                    Node leftNode = new Node(array[index], null, null);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                index++;
                if (array[index] != null) {
                    Node rightNode = new Node(array[index], null, null);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(rightNode, 1);
                    stack.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else { // state is 3 then pop.
                stack.pop();
            }
        }
        tiltOfBinaryTree(root);
        System.out.println(tilt);
    }
}
