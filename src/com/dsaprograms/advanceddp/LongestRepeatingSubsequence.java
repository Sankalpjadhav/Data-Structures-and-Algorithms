package com.dsaprograms.advanceddp;
import java.util.Scanner;
/*
Longest Repeating Subsequence (Based on Longest common subsequence)
1. You are given a string str.
2. You have to find the length of longest subsequence which is appearing twice in the string.
3. Every ith character in both the subsequences must have different indices in the original string.
Sample Input:
abacbc
Output:
3
 */
public class LongestRepeatingSubsequence {
    public static int lrs(String str){
        int [][] dp = new int[str.length()+1][str.length()+1]; // one extra for blank at last: which is always 0
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(j);
                if(ch1 == ch2 && i!=j){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Longest repeating subsequence: "+lrs(str));
    }
}
