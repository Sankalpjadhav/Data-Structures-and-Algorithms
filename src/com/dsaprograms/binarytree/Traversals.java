package com.dsaprograms.binarytree;
import java.util.Stack;
/*
Pre-order traversal:
50 25 12 37 30 75 62 70 87
In-order traversal:
12 25 30 37 50 62 70 75 87
Post-order traversal:
12 30 37 25 70 62 87 75 50
 */
public class Traversals {
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

    static void preorder(Node node){
        if(node==null){
            return ;
        }
        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
    static void inorder(Node node){
        if(node==null){
            return ;
        }
        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    static void postorder(Node node){
        if(node==null){
            return ;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
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
        System.out.println("Pre-order traversal:");
        preorder(root);
        System.out.println();
        System.out.println("In-order traversal:");
        inorder(root);
        System.out.println();
        System.out.println("Post-order traversal:");
        postorder(root);

    }
}
