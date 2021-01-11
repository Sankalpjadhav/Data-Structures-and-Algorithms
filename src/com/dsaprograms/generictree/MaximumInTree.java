package com.dsaprograms.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumInTree {
    public static class Node{
        int data;
        ArrayList<Node> childrens = new ArrayList<>();
    }

    public static int calculateMaximum(Node node){
        int maximum = 0;
        for(Node child : node.childrens){
            int max = calculateMaximum(child);
            maximum =  Math.max(maximum,max);
        }
        maximum = Math.max(maximum, node.data); //  Compare with parent.
        return maximum;
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
        System.out.println("Maximum element of the tree: "+calculateMaximum(root));
    }
}
