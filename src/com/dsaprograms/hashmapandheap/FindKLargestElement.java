package com.dsaprograms.hashmapandheap;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
public class FindKLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] array={12,62, 22,15, 37, 99, 11, 37, 98, 67, 31, 84, 99};
        int k = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int element:array){
            priorityQueue.add(element);
        }
        for(int j=0;j<k;j++){
            System.out.print(priorityQueue.remove()+" ");
        }
    }
}
