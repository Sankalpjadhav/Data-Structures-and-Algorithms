package com.dsaprograms.binarytree;

import java.util.Stack;

public class TransformToLeftClonedTree {
    // Node class
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

    static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    static void displayBinaryTree(Node node){
        if(node == null){ // Once there is call for its left or right child, there is possibility that they doesnt exist. In that case check if they are null and return;
            return;
        }
        String str = "";
        str += node.left!=null ? node.left.data: "."; // . represents there is no left or right child.
        str += "->"+node.data+"<-";
        str += node.right!=null ? node.right.data: ".";
        System.out.println(str);
        // Now display node's left and right children.
        displayBinaryTree(node.left);
        displayBinaryTree(node.right);
    }

    static Node transformToLeftClonedTree(Node node){
        if(node==null){
            return null;
        }

        Node leftCloned = transformToLeftClonedTree(node.left);
        Node rightCloned = transformToLeftClonedTree(node.right);

        Node newNode = new Node(node.data,leftCloned,null);
        node.left = newNode;
        node.right = rightCloned;
        return node;
    }

    public static void main(String[] args) {
        Integer [] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        /*
        State:
        1 indicates: next node to be entered at left position.
        2 indicates: next node to be entered at right position.
        3 indicates: pop from the stack.
         */
        Node root = new Node(array[0], null, null);
        Pair rootPair = new Pair(root,1);
        Stack<Pair> stack = new Stack<Pair>();
        stack.push(rootPair);
        int index = 0; // Index to access array elements.
        while(!stack.empty()){
            Pair top  = stack.peek();
            if(top.state==1){
                index++;
                if(array[index]!=null){
                    Node leftNode = new Node(array[index], null, null);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode,1);
                    stack.push(leftPair);
                }else{
                    top.node.left = null;
                }
                top.state++;
            }
            else if(top.state==2){
                index++;
                if(array[index]!=null){
                    Node rightNode = new Node(array[index], null, null);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(rightNode,1);
                    stack.push(rightPair);
                }else{
                    top.node.right = null;
                }
                top.state++;
            }else{ // state is 3 then pop.
                stack.pop();
            }
        }
        Node result = transformToLeftClonedTree(root);
        displayBinaryTree(result);
    }
}
