package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
 Similar to Maximum sum of non adjacent array elements.
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing
each of them is that adjacent houses have security system connected and it will automatically
contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber198 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int result = rob(arr);
        System.out.println(result);
    }
        public static int rob(int[] nums) {
            if(nums.length==0){
                return 0;
            }
            if(nums.length==1){
                return nums[0];
            }
            int include = nums[0];
            int exclude = 0;
            for(int i=1;i<nums.length;i++){
                int newInclude = exclude + nums[i];
                int newExclude = Math.max(include,exclude);
                include=newInclude;
                exclude=newExclude;
            }
            return Math.max(include,exclude);
        }
}