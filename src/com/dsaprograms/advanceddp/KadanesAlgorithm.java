package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Kadane's Algorithm for Maximum Sum Subarray
1. You are given an array(arr) of integers.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least one element.
Sample input:
19
4
3
-2
6
7
-10
-10
4
5
9
-3
4
7
-28
2
9
3
2
11
Output:
Maximum subarray sum: 27
 */
public class KadanesAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int currentSum = array[0];
        int overallSum = array[0];
        for(int i=1;i<n;i++){
            if(currentSum >=0){
                currentSum += array[i];
            }
            else{
                currentSum = array[i];
            }
            if(currentSum > overallSum){
                overallSum = currentSum;
            }
        }
        System.out.println("Maximum subarray sum: "+overallSum);
    }
}
