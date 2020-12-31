package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
LeetCode : 213 House robber 2
You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security
system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:
Input: nums = [0]
Output: 0
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000

We can divide this problem to two sub problems:
Let's take following example:
Subproblem 1: rob house 1 ~ 8
Subproblem 2: rob house 2 ~ 9
And find the bigger one of these two sub problems.

                 1
            9        2
           8          3
            7        4
               6   5

 */
public class House2Robber213 {
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
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(robHouses(nums,0,nums.length-1), robHouses(nums,1,nums.length));
    }

    public static int robHouses(int [] nums, int low, int high){
        int include = nums[low];
        int exclude = 0;
        for(int i=low+1;i<high;i++){
            int newInclude = exclude + nums[i];
            int newExclude = Math.max(include,exclude);
            include=newInclude;
            exclude=newExclude;
        }
        return Math.max(include,exclude);
    }
}
