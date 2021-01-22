package com.dsaprograms.hashmapandheap;

import java.util.PriorityQueue;
import java.util.Scanner;
/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. The array is nearly sorted. Every element is at-max displaced k spots left or right to it's position in the sorted array. Hence it is being called k-sorted array.
4. You are required to sort and print the sorted array.

Note -> You can use at-max k extra space and nlogk time complexity.
 */

public class SortKSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        PriorityQueue < Integer > pq = new PriorityQueue < > ();
        for (int i = 0; i <= k; i++) {
            pq.add(array[i]);
        }

        for (int i = k + 1; i < array.length; i++) {
            System.out.print(pq.remove()+" ");
            pq.add(array[i]);
        }

        while (pq.size() > 0) {
            System.out.print(pq.remove()+" ");
        }
    }
}
