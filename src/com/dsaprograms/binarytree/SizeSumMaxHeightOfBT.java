package com.dsaprograms.binarytree;

import java.util.Stack;
/*
Sample output:
Size of a binary tree: 9
Sum of a binary tree: 448
Maximum element of a binary tree: 87
Height of a binary tree: 4
 */
public class SizeSumMaxHeightOfBT {
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
    //To calculate Size
    static int size(Node node){
     if(node == null){
         return 0;
     }
     int leftSize = size(node.left);
     int rightSize = size(node.right);
     int totalSize = leftSize + rightSize + 1;
     return totalSize;
    }
    //To calculate Sum
    static int sum(Node node){
        if(node == null){
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int totalSum = leftSum + rightSum + node.data;
        return totalSum;
    }
    //To calculate Maximum element
    static int max(Node node){
        if(node == null){
            return 0;
        }
        int maxLeft = max(node.left);
        int maxRight = max(node.right);
        int maxELement = Math.max(node.data,Math.max(maxLeft,maxRight));
        return maxELement;
    }
    //To calculate Height
    static int height(Node node){
        if(node == null){
            return 0; // return 0 if finding wrt nodes , return -1 wrt edges.
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int totalHeight = Math.max(leftHeight , rightHeight) + 1; // Find the max height of its left and right child and add 1 to take care of root.
        return totalHeight;
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
        System.out.println("Size of a binary tree: "+size(root));
        System.out.println("Sum of a binary tree: "+sum(root));
        System.out.println("Maximum element of a binary tree: "+max(root));
        System.out.println("Height of a binary tree: "+height(root));
    }
}
