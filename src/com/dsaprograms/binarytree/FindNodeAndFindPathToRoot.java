package com.dsaprograms.binarytree;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
/*
30
Node found: true
[30, 37, 25, 50]
 */
public class FindNodeAndFindPathToRoot {
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

    static ArrayList<Integer> path;
    static boolean findNodeAndFindPathToRoot(Node node, int data){
        if(node==null){
            return false;
        }
        if(node.data == data){
            path.add(node.data); // Add to path if found true.
            return true;
        }
        boolean left = findNodeAndFindPathToRoot(node.left, data);
        if(left){
            path.add(node.data); // Add to path if found true.
            return true;
        }
        boolean right = findNodeAndFindPathToRoot(node.right, data);
        if(right){
            path.add(node.data); // Add to path if found true.
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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
        int data = sc.nextInt();
        path = new ArrayList<>();
        System.out.println("Node found: "+findNodeAndFindPathToRoot(root, data));
        System.out.println(path);
    }
}
