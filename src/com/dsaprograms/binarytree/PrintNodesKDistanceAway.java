package com.dsaprograms.binarytree;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
1. You are given a partially written BinaryTree class.
2. You are given a value data and a value k.
3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
4. Input is managed for you.
Input Format
Input is managed for you
Output Format
All nodes which are k distance away in any direction from node with value equal to data, each in a separate line
Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2
Sample Output
12
50
 */
public class PrintNodesKDistanceAway {
    // class Node
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
    // class Pair
    static class Pair{
        Node node;
        int state;
        Pair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }

    static ArrayList<Node> path;
    static boolean findNodeAndPath(Node node, int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            path.add(node);
            return true;
        }

        boolean left = findNodeAndPath(node.left,data);
        if(left){
            path.add(node);
            return true;
        }
        boolean right = findNodeAndPath(node.right,data);
        if(right){
            path.add(node);
            return true;
        }
        return false;
    }

    static void printKLevelsDown(Node node, int k, Node blocker){
        if(node==null || k<0 || blocker==node){
            return;
        }
        if(k==0){
            System.out.println(node.data);
        }
        printKLevelsDown(node.left, k-1, blocker);
        printKLevelsDown(node.right, k-1, blocker);
    }

    static void printNodesKDistanceAway(Node node, int data, int k){
        path = new ArrayList<>();
        findNodeAndPath(node,data);
        for(int i=0;i<path.size();i++){
            printKLevelsDown(path.get(i), k-i,i==0?null:path.get(i-1));
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer [] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        // Construct a tree.
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
        int data = sc.nextInt();
        int k = sc.nextInt();
        printNodesKDistanceAway(root,data,k);
    }
}
