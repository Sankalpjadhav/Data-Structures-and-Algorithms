package com.dsaprograms.basedonsorting;
import java.util.Scanner;
/*
1. You are given an array(arr) of integers and a pivot.
2. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side.
3. You have to achieve this in linear time.
 */
public class PartitionArrayBasedOnPivot {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int pivot = scn.nextInt();
        partition(arr,pivot);
        print(arr);
    }
    public static void partition(int[] arr, int pivot){
        //[12,3,7,2,9] Pivot: 5
        int i=0;
        int j=0;
        while(j<arr.length){
            if(arr[j]<=pivot){
                swap(arr, i, j);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
    }
    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
