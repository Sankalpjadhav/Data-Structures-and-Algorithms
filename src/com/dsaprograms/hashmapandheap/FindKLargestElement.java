package com.dsaprograms.hashmapandheap;
import java.util.PriorityQueue;
import java.util.Scanner;
public class FindKLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] array={12,62, 22,15, 37, 99, 11, 37, 98, 67, 31, 84, 99};
        int k = sc.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i< array.length;i++){
            if(i<k){
                priorityQueue.add(array[i]);
            }
            else{
                if(array[i]>priorityQueue.peek()){
                    priorityQueue.remove();
                    priorityQueue.add(array[i]);
                }
            }
        }
        while(priorityQueue.size()>0){
            System.out.print(priorityQueue.remove()+" ");
        }
    }
}
