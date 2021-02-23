package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 45 Jump Game II
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.
Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
 */
public class LeetCode45JumpGame2 {
    public static int getMinimumJumps(int [] nums){
        Integer [] dp = new Integer[nums.length];
        dp[nums.length-1] = 0;
        for(int index=dp.length-2;index>=0;index--){
            int steps = nums[index];
            int minimum = Integer.MAX_VALUE;
            for(int possibleJump = 1;possibleJump<=steps && index+possibleJump<dp.length;possibleJump++){
                if(dp[index+possibleJump]!=null && dp[index+possibleJump]<minimum){
                    minimum = dp[index+possibleJump];
                }
            }
            if(minimum!=Integer.MAX_VALUE){
                dp[index] = minimum+1;
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Minimum number of jumps required to reach last index: "+getMinimumJumps(nums));
    }
}
