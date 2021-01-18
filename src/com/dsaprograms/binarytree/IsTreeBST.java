package com.dsaprograms.binarytree;
import java.util.Stack;
/*
1. You are given a partially written BinaryTree class.
2. You are required to check if the tree is a Binary Search Tree (BST) as well.
In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
3. Input is managed for you.
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
Sample Output
true
 */
public class IsTreeBST {
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

    static class BSTPair{
        int min;
        int max;
        boolean isBST;
    }

    static BSTPair isBST(Node node){
        if(node==null){
            BSTPair base = new BSTPair();
            base.min =  Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            base.isBST = true;
            return base;
        }
        BSTPair left = isBST(node.left);
        BSTPair right = isBST(node.right);

        BSTPair myPair = new BSTPair();
        myPair.isBST = left.isBST && right.isBST && (node.data >= left.max && node.data <= right.min);
        myPair.min = Math.min(node.data,Math.min(left.min,right.min));
        myPair.max = Math.max(node.data, Math.max(left.max,right.max));
        return myPair;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
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
        BSTPair result = isBST(root);
        System.out.println(result.isBST);
    }
}

