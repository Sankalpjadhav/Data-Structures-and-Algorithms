package com.dsaprograms.basedonsorting;
import java.util.Scanner;
public class SortZerosOnesTwos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
            arr[i] = scn.nextInt();
        }
        sort012(arr);
        print(arr);
    }

    public static void sort012(int [] arr){
    int i=0,j=0,k=arr.length-1;
    while(j<k){
        if(arr[j]==0){
            swap(arr,i,j);
            i++;
            j++;
        }
        else if(arr[j]==1){
            j++;
        }
        else{// arr[j]==2
            swap(arr,j,k);
            j++;
            k--;
        }
    }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
