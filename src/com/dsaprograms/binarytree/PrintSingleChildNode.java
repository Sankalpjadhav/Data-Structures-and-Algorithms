package com.dsaprograms.binarytree;
import java.util.Stack;
/*
1. You are given a partially written BinaryTree class.
2. You are required to complete the body of printSingleChildNodes function. The function is expected to print in separate lines, all such nodes which are only child of their parent. Use preorder for traversal.
3. Input and Output is managed for you.
Input Format
Input is managed for you.
Output Format
Output is managed for you.
Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Sample Output
30
70
 */
public class PrintSingleChildNode {
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

    static void printSingleChildNode(Node node, Node parent){
        if(node==null){
            return;
        }
        if(parent!=null && parent.left==node && parent.right==null){
            System.out.println(node.data);
        }
        else if(parent!=null && parent.right==node && parent.left==null){
            System.out.println(node.data);
        }

        printSingleChildNode(node.left,node);
        printSingleChildNode(node.right,node);
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
        printSingleChildNode(root,null);
    }
}


