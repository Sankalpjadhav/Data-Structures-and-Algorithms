package com.dsaprograms.basedonsorting;
import java.util.Scanner;
public class RadixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        radixSort(arr);
        print(arr);
    }
    static void radixSort(int [] arr){
        // Count sort will run for maximum element present in the given array(2314- 4 times).
        int max=Integer.MIN_VALUE;
        for (int i:arr){
            if(i>max){
                max=i;
            }
        }
        int exp=1;
        while(exp<=max){
            countSort(arr,exp);
            exp=exp*10;
        }
    }
    static void countSort(int [] arr, int exp){
        int[] ans = new int[arr.length];
        // make frequency arr
        int[] farr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            farr[(arr[i]/exp) % 10]++;
        }
        // convert it into prefix sum array
        for (int i = 1; i < farr.length; i++) {
            farr[i] += farr[i - 1];
        }
        // stable sorting(filling ans array)
        for (int i = arr.length - 1; i >= 0; i--) {
            int pos = farr[(arr[i]/exp) % 10] - 1;
            ans[pos] = arr[i];
            farr[(arr[i]/exp) % 10]--;
        }
        // filling original array with the help of ans array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }
    }
    static void print(int []arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
