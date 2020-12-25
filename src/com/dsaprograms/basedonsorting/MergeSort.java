package com.dsaprograms.basedonsorting;
import java.util.Scanner;
public class MergeSort {
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int[] sa = mergeSort(arr,0,arr.length - 1);
        System.out.print("Sorted Array -> ");
        print(sa);
    }

    public static int [] mergeSort(int[] arr, int low, int high){
        if(low==high){
            int [] base =new int[1];
            base[0]=arr[low];
            return base;
        }
        int mid = (low+high)/2;
        int[] firstPart = mergeSort(arr,low,mid);
        int [] secondPart = mergeSort(arr,mid+1,high);
        int [] result = mergeTwoSortedArray(firstPart,secondPart);
        return result;
    }

    public static int[] mergeTwoSortedArray(int [] first, int [] second){
        int [] result = new int[first.length+ second.length];
        int i=0,j=0,k=0;
        while(i<first.length && j<second.length){
            if(first[i]<=second[j]){
                result[k++]=first[i];
                i++;
            }
            else{
                result[k++]=second[j];
                j++;
            }
        }
        while(i<first.length){
            result[k++]=first[i];
            i++;
        }

        while(j<second.length){
            result[k++]=second[j];
            j++;
        }
        return result;
    }
}
