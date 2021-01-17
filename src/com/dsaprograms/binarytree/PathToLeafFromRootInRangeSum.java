package com.dsaprograms.binarytree;
import java.util.Scanner;
import java.util.Stack;
/*
1. You are given a partially written BinaryTree class.
2. You are given a value lo and a value hi
3. You are required to complete the body of pathToLeafFromRoot function. The function is expected to print all paths from root to leaves which have sum of nodes in range from lo to hi (both inclusive). The elements in path should be separated by spaces. Each path should be in a separate line.
4. Input is managed for you.
Input Format
Input is managed for you
Output Format
The elements in path should be separated by spaces. Each path should be in a separate line.
Constraints
None
Sample Input
50 25 12 n n 37 30 n n n 75 62 n n 70 n n 87 n n
40
250
OUTPUT:
50 25 12
50 25 37 30
50 75 87
 */
public class PathToLeafFromRootInRangeSum {
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
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    static void printPathToLeafFromRootInRangeSum(Node node,String path,int sum, int low, int high){
        if(node == null)
        {
            return;
        }

        if(node.left==null && node.right==null){
            sum+=node.data;
            if(sum>=low && sum<=high){
                System.out.println(path+node.data);
            }
            return;
        }

        printPathToLeafFromRootInRangeSum(node.left,path+node.data+" ",sum+node.data,low,high);
        printPathToLeafFromRootInRangeSum(node.right,path+node.data+" ",sum+node.data,low,high);
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
        int low = sc.nextInt();
        int high = sc.nextInt();
        printPathToLeafFromRootInRangeSum(root,"",0,low,high);
    }
}
