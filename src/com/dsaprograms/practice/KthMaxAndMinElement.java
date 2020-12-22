package com.dsaprograms.practice;

import java.util.PriorityQueue;

public class KthMaxAndMinElement {
    public static void main(String[] args) {
        int [] array = {2,40,1,5,16,17,3,10};
        int k=4;
        System.out.println(minKthElement(array,k));
        System.out.println(maxKthElement(array,k));

    }

    public static int minKthElement(int [] array, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele:array){
            pq.add(ele);
        }
        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.peek();
    }

    public static int maxKthElement(int [] array, int k){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y)->Integer.compare(y,x));
        for(int ele:array){
            priorityQueue.add(ele);
        }
        for(int i=0;i<k-1;i++){
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }
}
