package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 300
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements.
For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */
public class LeetCode300LongestIncreasingSubseq {
    public static int lengthOfLIS(int [] nums){
        int [] dp = new int[nums.length];
        int maxLength = Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if(dp[i]>maxLength){
                maxLength = dp[i];
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Length of longest increasing subsequence: "+lengthOfLIS(nums));
    }
}
