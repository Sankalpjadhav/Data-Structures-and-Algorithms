package com.dsaprograms.binarytree;

import java.util.Stack;

/*
1. You are given a partially written BinaryTree class.
2. You are required to check if the tree is balanced. A binary tree is balanced if for every node the gap between height's of it's left and right subtree is not more than 1.
3. Input is managed for you.

Output Format
true if the tree is balanced, false otherwise
Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
21
50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n n
Sample Output
false
 */
public class BalancedTree {
    // Class Node
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data,Node left, Node right){
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

    static boolean isBalance = true;
    static int isBalanced(Node node) {
        if(node==null) {
             return 0;
        }

        int leftHeight = isBalanced(node.left);
        int rightHeight = isBalanced(node.right);

        int gap = leftHeight - rightHeight;
        if(gap > 1) {
            isBalance = false;
        }

        int totalHeight = Math.max(leftHeight,rightHeight) + 1;
        return totalHeight;
    }

    public static void main(String[] args) {
        Integer[] array = {50,25, 12, null, null, 37, 30, null, null, 51, null, null, 75, 62, 60, null, null, 70, null, null, null};
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
        isBalanced(root);
        System.out.println(isBalance);
    }
}

