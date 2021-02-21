package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Maximum sum of longest increasing subsequence based on longest increasing subsequence program.
1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the sum of elements of the increasing subsequence with maximum sum for the array.
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
255
 */
public class MaxSumOfLongestIncSubs {
    public static int maxSumOfLIS(int [] nums){
        int maxSum = Integer.MIN_VALUE;
        int [] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + nums[i];
            if(dp[i]>maxSum){
                maxSum = dp[i];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Maximum sum of longest increasing subsequence: "+maxSumOfLIS(nums));
    }
}
