package com.dsaprograms.practice;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
Two methods:
1. By sorting and returning k-1 th element.
Time complexity: O(nlogn).
Space complexity: O(1).
2. Using PriorityQueue.
Time complexity: O(n).
Space complexity: O(n).
*/
public class KthMinElement {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [] arr = {31,5,1,78,7,8};
        int k=sc.nextInt();
        int minimumElement = kthMinElement(arr, k);
        System.out.println(minimumElement);
    }
    public static int kthMinElement(int [] arr, int k){
        /*
        1. By sorting:
        Arrays.sort(arr);
        return arr[k-1];
         */
        //2. Using PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();
    }
}
