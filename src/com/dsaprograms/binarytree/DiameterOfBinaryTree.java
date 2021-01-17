package com.dsaprograms.binarytree;

import java.util.Stack;
/*
1. You are given a partially written BinaryTree class.
2. You are required to complete the body of diameter1 function. The function is expected to return the number
of edges between two nodes which are farthest from each other in terms of edges.
3. Input and Output is managed for you.
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Sample Output
6
 */

// Not consistent solution
public class DiameterOfBinaryTree {
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

    static int height(Node node){
        if(node == null){
            return -1; // Based on edges.
        }
        int left = height(node.left);
        int right = height(node.right);
        int height = Math.max(left,right) + 1;
        return height;
    }

   static int diameterOfBinaryTree(Node node){
        if(node==null){
            return 0;
        }
        // Max diameter only on left side.
        int leftDiameter = diameterOfBinaryTree(node.left);
        // Max diameter only on right side.
       int rightDiameter = diameterOfBinaryTree(node.right);
       // Max distance between left deepest and right deepest.
       int dia = height(node.left) + height(node.right) + 2;

       int diameter = Math.max(dia,Math.max(leftDiameter,rightDiameter));
       return diameter;
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
        System.out.print(diameterOfBinaryTree(root));
    }
}

