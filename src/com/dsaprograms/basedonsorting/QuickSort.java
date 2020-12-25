package com.dsaprograms.basedonsorting;
import java.util.Scanner;
public class QuickSort {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        quickSort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void quickSort(int [] arr, int low, int high){
        if(low>=high){
            return;
        }
        int pivot = arr[high];
        int partitionIndex = partitionArray(arr, low, high, pivot);
        quickSort(arr, low, partitionIndex-1);
        quickSort(arr, partitionIndex+1, high);
    }

    public static int partitionArray(int [] arr, int low, int high, int pivot){
        int i=low,j=low;
        while(j<=high){
            if(arr[j]<=pivot){
                swap(arr, i, j);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i-1;
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
