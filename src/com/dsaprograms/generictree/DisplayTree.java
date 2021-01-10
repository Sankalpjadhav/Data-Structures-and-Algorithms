package com.dsaprograms.generictree;
import java.util.ArrayList;
import java.util.Stack;
/*
10-->20 30 40
20-->50 60
50-->
60-->
30-->70 80 90
70-->
80-->110 120
110-->
120-->
90-->
40-->100
100-->
                                        10
                            20          30         40
                         50    60   70  80  90     100
                                    110    120
 */
public class DisplayTree {
    public static class Node{
        int data;
        ArrayList<Node> childrens = new ArrayList<Node>();
    }

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

    public static void main(String[] args) {
        int [] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root = null;
        Stack<Node> stack = new Stack<Node>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                stack.pop();
            }
            else{
                Node node = new Node();
                node.data = arr[i];

                if(stack.size()>0){
                    stack.peek().childrens.add(node);
                }
                else { // Root element
                    root = node;
                }
                stack.push(node);
            }
        }

        display(root);
    }
}
