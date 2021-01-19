package com.dsaprograms.binarytree;
import java.util.Stack;
/*
2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
3. Input is managed for you.
Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)
Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
Sample Output
50@7
 */
public class LargestBSTSubtree {
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
        Node bstRoot;
        int bstSize;
    }

    static BSTPair isBST(Node node){
        if(node==null){
            BSTPair base = new BSTPair();
            base.min =  Integer.MAX_VALUE;
            base.max = Integer.MIN_VALUE;
            base.isBST = true;
            base.bstRoot = null;
            base.bstSize = 0;
            return base;
        }
        BSTPair left = isBST(node.left);
        BSTPair right = isBST(node.right);

        BSTPair myPair = new BSTPair();
        myPair.isBST = left.isBST && right.isBST && (node.data >= left.max && node.data <= right.min);
        myPair.min = Math.min(node.data,Math.min(left.min,right.min));
        myPair.max = Math.max(node.data, Math.max(left.max,right.max));

        if(myPair.isBST){
            myPair.bstRoot = node;
            myPair.bstSize = left.bstSize + right.bstSize + 1;
        }
        else if(left.bstSize > right.bstSize){
            myPair.bstRoot = left.bstRoot;
            myPair.bstSize = left.bstSize;
        }
        else if(right.bstSize > left.bstSize){
            myPair.bstRoot = right.bstRoot;
            myPair.bstSize = right.bstSize;
        }

        return myPair;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, null, null, 75, 62, null, null, 87, null, null};
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
        System.out.println(result.bstRoot.data+"@"+result.bstSize);
    }
}

