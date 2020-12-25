package com.dsaprograms.basedonsorting;
import java.util.Scanner;
/*
Application:
Find Kth smallest element
 */
public class QuickSelect {
    public static int quickSelect(int[] arr, int lo, int hi, int k) {
        //write your code here
        int partitionIndex=partition(arr,arr[hi],lo,hi);
        if(partitionIndex==k){
            return arr[partitionIndex];
        }
        else if(partitionIndex<k){
            return quickSelect(arr,partitionIndex+1,hi,k);
        }
        else{
            return quickSelect(arr,lo,partitionIndex-1,k);
        }

    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(quickSelect(arr,0,arr.length - 1,k - 1));
    }

}
