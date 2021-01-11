package com.dsaprograms.generictree;

import java.util.ArrayList;
import java.util.Stack;

public class SizeOfTree {
    public static class Node{
        int data;
        ArrayList<Node> childrens = new ArrayList<Node>();
    }
    /*
    public static void display(Node node){
        String str = node.data + "-->";
        for(Node child : node.childrens){
            str += child.data+" ";
        }
        System.out.println(str);

        for(Node child : node.childrens){
            display(child);
        }
    }
    */
    public static int calculateSize(Node node){
        int size = 0;
        for(Node child : node.childrens){
            size += calculateSize(child);
        }
        size = size + 1; // Consider root element.
        return size;
    }

    public static void main(String [] args){
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
        //display(root);
        System.out.println("Size of the tree: "+calculateSize(root));
    }
}
