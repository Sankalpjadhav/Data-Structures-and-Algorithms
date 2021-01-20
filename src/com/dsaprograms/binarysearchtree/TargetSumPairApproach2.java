package com.dsaprograms.binarysearchtree;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
// Time Complexity: O(n)
public class TargetSumPairApproach2 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack < > ();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    static ArrayList<Integer> nodeData = new ArrayList<Integer>();
    public static void targetSumPairApproach2(Node node, int target){
        if(node==null){
            return ;
        }
        targetSumPairApproach2(node.left, target);
        nodeData.add(node.data);
        targetSumPairApproach2(node.right, target);
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, 60, null, null, 70, null, null, 87, null, null};
        Node root = construct(array);
        int target = sc.nextInt();
        targetSumPairApproach2(root,target);
        int left = 0;
        int right = nodeData.size()-1;
        while(left<right){
            if(nodeData.get(left) + nodeData.get(right) < target){
                left++;
            }
            else if(nodeData.get(left) + nodeData.get(right) > target){
                right--;
            }
            else{
                System.out.println(nodeData.get(left)+" "+nodeData.get(right));
                left++;
                right--;
            }
        }
    }
}

