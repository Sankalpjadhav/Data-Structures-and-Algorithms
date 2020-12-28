package com.dsaprograms.dynamicprogramming;
import java.util.Scanner;
/*
1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item
               again and again.
 */
public class Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < weights.length; i++) {
            weights[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        int[][] dp = new int[values.length + 1][capacity + 1];
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                if (col >= weights[row - 1]) {
                    int remainingCapacity = col - weights[row - 1];
                    dp[row][col] = Math.max(dp[row - 1][remainingCapacity] + values[row - 1], dp[row - 1][col]);
                    /*
                    dp[row-1][remainingCapacity]+values[row-1] - when we include.
                    dp[row-1][col] - when we don't include.
                     */
                } else {
                    dp[row][col] = dp[row - 1][col];
                }
            }
        }
        System.out.println("Maximum value me can add in " + capacity + " is: " + dp[n][capacity]);
    }
}
