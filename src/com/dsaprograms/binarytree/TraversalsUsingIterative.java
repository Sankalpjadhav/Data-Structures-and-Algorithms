package com.dsaprograms.binarytree;
import java.util.Stack;
/*
Pre-order
50 25 12 37 30 75 62 70 87
In-order
12 25 30 37 50 62 70 75 87
Post-order
12 30 37 25 70 62 87 75 50
 */
public class TraversalsUsingIterative {
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

    static void iterativeTraversals(Node node){
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(new Pair(node,1));
        String preOrder="";
        String inOrder="";
        String postOrder="";
        while(!stack.isEmpty()){
            Pair top = stack.peek();
            if(top.state==1){ // Represents node is in pre-order state.
                preOrder+=top.node.data+" ";
                if(top.node.left!=null) {
                    stack.push(new Pair(top.node.left, 1));
                }
                top.state++;
            }
            else if(top.state==2){ // Represents node is in in-order state.
                inOrder+=top.node.data+" ";
                if(top.node.right!=null) {
                    stack.push(new Pair(top.node.right, 1));
                }
                top.state++;
            }
            else{ // Represents node is in post-order state.
                postOrder+=top.node.data+" ";
                stack.pop();
            }
        }
        System.out.println("Pre-order");
        System.out.println(preOrder);
        System.out.println("In-order");
        System.out.println(inOrder);
        System.out.println("Post-order");
        System.out.println(postOrder);
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
        Stack<Pair> stack = new Stack<>();
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
        iterativeTraversals(root);
    }
}
