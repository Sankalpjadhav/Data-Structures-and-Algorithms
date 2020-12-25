package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
LeetCode problem
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */
public class MinimumCostClimbingStairs {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] cost = new int[n];
        for(int i = 0 ;i < n; i++){
            cost[i] = scn.nextInt();
        }
        int result = minCostClimbingStairs(cost);
        System.out.println(result);
    }
    public static int minCostClimbingStairs(int[] cost) {
        // You have a choice that you can either start with index 0 or index 1.
        int indexZero=usingRecursion(0,cost,new int[cost.length+1]);
        int indexOne=usingRecursion(1,cost,new int[cost.length+1]);
        return Math.min(indexZero,indexOne);
    }

    public static int usingRecursion(int index,int []cost, int [] mimo){
        if(index==cost.length-1||index==cost.length-2){
            return cost[index];
        }
        if(mimo[index]!=0){
            return mimo[index];
        }
        // Once you pay the price(meaning adding cost[index]) you have two choices:
        // 1. You can you can either climb one step(index+1).
        // 2. Or you can climb two steps(index+2).
        int oneStep=cost[index]+usingRecursion(index+1,cost,mimo);
        int twoStep=cost[index]+usingRecursion(index+2,cost,mimo);
        // Return the result which is minimum
        int result=Math.min(oneStep,twoStep);
        mimo[index]=result;
        return result;

    }
}
