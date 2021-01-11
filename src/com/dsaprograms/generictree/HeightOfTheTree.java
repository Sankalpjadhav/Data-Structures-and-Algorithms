package com.dsaprograms.generictree;
import java.util.ArrayList;
import java.util.Stack;
public class HeightOfTheTree {
    public static class Node{
        int data;
        ArrayList<Node> childrens = new ArrayList<Node>();
    }

    public static int calculateHeight(Node node){
        int height = -1; // Calculating height based on edges(for this the height of the only root node is 0).
        // Use height=0 if calculating height based on nodes(for this the height of the only root node is 1).
        for(Node child: node.childrens){
            int childHeight = calculateHeight(child);
            height = Math.max(childHeight, height);
        }
        height = height + 1;
        return height;
    }
    public static void main(String[] args) {
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root  = null;
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]==-1){
                stack.pop();
            }else{
                Node node = new Node();
                node.data = arr[i];
                if(stack.size()>0){
                    stack.peek().childrens.add(node);
                }
                else{
                    root = node;
                }
                stack.push(node);
            }
        }
        System.out.println("Height of the tree: "+calculateHeight(root));
    }
}
