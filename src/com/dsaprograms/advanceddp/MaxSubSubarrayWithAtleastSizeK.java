package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Maximum Sum Subarray with at least Size K
1. You are given an array(arr) of integers and a number k.
2. You have to find maximum sub-array sum in the given array.
3. The sub-array must have at least k elements.
Sample Input
3
1
2
3
2
Sample Output
6

Sample Input
n = 18
2 3 1 -7 6 -5 -4 4 3 3 2 -9 -5 6 1 2 1 4
k = 4
Maximum sum of sub-array with at least K size: 14
 */
public class MaxSubSubarrayWithAtleastSizeK {
    public static int maxSum(int [] array, int n, int k){
        int answer = Integer.MIN_VALUE;
        int currentSum = array[0];
        int [] maxSum = new int[n];
        maxSum[0] = array[0];
        for(int i=1;i<n;i++){
            if(currentSum > 0){
                currentSum += array[i];
            }
            else{
                currentSum = array[i];
            }
            maxSum[i] = currentSum;
        }
        int exactK = 0;
        for(int i=0;i<k;i++){
            exactK += array[i];
        }
        if(exactK > answer){
            answer = exactK;
        }

        int moreThanK = 0;
        for(int i=k;i<n;i++){
            exactK = exactK + array[i] - array[i-k];
            if(exactK > answer){
                answer = exactK;
            }
            moreThanK = maxSum[i-k] + exactK;
            if(moreThanK > answer){
                answer = moreThanK;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println("Maximum sum of sub-array with at least K size: "+maxSum(array, n, k));
    }
}
