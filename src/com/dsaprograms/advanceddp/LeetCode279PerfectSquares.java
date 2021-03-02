package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
LeetCode: 279. Perfect Squares.
Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 */
public class LeetCode279PerfectSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int [] dp = new int[number+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<dp.length;i++){
            int minimum = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int remaining = i - j*j;
                if(dp[remaining] < minimum){
                    minimum = dp[remaining];
                }
            }
            dp[i] = minimum + 1;
        }
        System.out.println("The least number of perfect square numbers that sum to number: "+dp[number]);
    }
}
