package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode:  413. Arithmetic Slices
https://leetcode.com/problems/arithmetic-slices/
An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.
A subarray is a contiguous subsequence of the array.
Example 1:
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:
Input: nums = [1]
Output: 0
 */
public class LeetCode413ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        if(A.length<=1){
            return 0;
        }
        int [] dp = new int[A.length];
        dp[0] = 0;
        dp[1] = 0;
        int sum=0;
        for(int i=2;i<dp.length;i++){
            int value1 = A[i] - A[i-1];
            int value2 = A[i-1] - A[i-2];
            if(value1 == value2){
                dp[i] = dp[i-1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] A = new int[n];
        System.out.println("The number of arithmetic subarrays of nums: "+ numberOfArithmeticSlices(A));
    }
}
